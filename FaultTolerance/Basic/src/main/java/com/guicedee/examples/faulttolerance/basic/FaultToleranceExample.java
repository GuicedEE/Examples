package com.guicedee.examples.faulttolerance.basic;

import com.guicedee.client.IGuiceContext;

/**
 * Demonstrates MicroProfile Fault Tolerance annotations with GuicedEE.
 * <p>
 * The {@link ResilientService} class uses {@code @Retry}, {@code @Timeout},
 * {@code @Fallback}, and {@code @CircuitBreaker} — all handled automatically
 * by Guice AOP interceptors registered during bootstrap.
 */
public class FaultToleranceExample
{
    public static void main(String[] args)
    {
        IGuiceContext.instance();

        ResilientService service = IGuiceContext.get(ResilientService.class);

        // Retry example — retries up to 3 times on failure
        System.out.println("Retry result: " + service.fetchWithRetry());

        // Fallback example — falls back to a safe default on failure
        System.out.println("Fallback result: " + service.fetchWithFallback());

        // Timeout example — method must complete within the timeout
        System.out.println("Timeout result: " + service.fetchWithTimeout());
    }
}

