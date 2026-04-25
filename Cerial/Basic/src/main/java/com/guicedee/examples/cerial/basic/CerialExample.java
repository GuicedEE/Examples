package com.guicedee.examples.cerial.basic;

import com.guicedee.cerial.CerialPortConnection;
import com.guicedee.cerial.enumerations.BaudRate;
import com.guicedee.cerial.enumerations.DataBits;
import com.guicedee.cerial.enumerations.FlowControl;
import com.guicedee.cerial.enumerations.Parity;
import com.guicedee.cerial.enumerations.StopBits;
import com.guicedee.client.IGuiceContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates serial port connectivity with @Named CerialPortConnection injection.
 * Requires a physical serial device or simulator on COM port 1.
 * <p>
 * Configuration is done with CRTP-fluent setters: baud rate, data bits, parity,
 * stop bits, and flow control. Includes automatic reconnect with exponential backoff.
 */
public class CerialExample
{
    @Inject
    @Named("1")
    private CerialPortConnection connection;

    public void connectAndSend()
    {
        connection.setBaudRate(BaudRate.$9600)
                .setDataBits(DataBits.$8)
                .setParity(Parity.None)
                .setStopBits(StopBits.$1)
                .setFlowControl(FlowControl.None);

        // Register a read callback
        connection.setComPortRead((data, port) ->
        {
            String message = new String(data).trim();
            System.out.println("Received from serial port: " + message);
        });

        connection.connect();
        connection.write("Hello, device!");
    }

    public static void main(String[] args)
    {
        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.cerial.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Cerial example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        CerialExample example = IGuiceContext.get(CerialExample.class);
        // Uncomment to connect (requires a serial device on port 1):
        // example.connectAndSend();
        System.out.println("Cerial port connection configured. Uncomment connectAndSend() to test with hardware.");
    }
}

