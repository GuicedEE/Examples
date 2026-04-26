package com.guicedee.examples.ibmmq.basic;

import com.guicedee.ibmmq.IBMMQConsumer;
import com.guicedee.ibmmq.IBMMQQueueDefinition;
import com.guicedee.ibmmq.IBMMQQueueOptions;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;

/**
 * Consumes messages from the "DEV.QUEUE.1" queue.
 * Discovered automatically via ClassGraph.
 */
@IBMMQQueueDefinition(
        value = "DEV.QUEUE.1",
        options = @IBMMQQueueOptions(worker = true)
)
public class OrderConsumer implements IBMMQConsumer
{
    @Override
    public void consume(Message message)
    {
        try
        {
            if (message instanceof TextMessage tm)
            {
                System.out.println("Received order event: " + tm.getText());
            }
            else
            {
                System.out.println("Received message: " + message.getJMSMessageID());
            }
        }
        catch (JMSException e)
        {
            throw new RuntimeException("Failed to process message", e);
        }
    }
}

