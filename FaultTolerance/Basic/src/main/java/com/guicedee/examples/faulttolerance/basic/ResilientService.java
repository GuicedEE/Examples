package com.guicedee.examples.faulttolerance.basic;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A service demonstrating MicroProfile Fault Tolerance annotations.
 * <p>
 * Each method showcases a different fault tolerance pattern. Guice AOP
 * interceptors registered by the {@code fault-tolerance} module handle
 * the retry, timeout, fallback, and circuit breaker logic automatically.
 */
public class ResilientService
{
    private final AtomicInteger retryCounter = new AtomicInteger(0);

    /**
     * Retries up to 3 times with a 200 ms delay between attempts.
     * Succeeds on the third attempt.
     */
    @Retry(maxRetries = 3, delay = 200)
    public String fetchWithRetry()
    {
        int attempt = retryCounter.incrementAndGet();
        if (attempt < 3)
        {
            throw new RuntimeException("Transient failure — attempt " + attempt);
        }
        return "Success after " + attempt + " attempts";
    }

    /**
     * Always fails, but the {@code @Fallback} annotation redirects
     * to {@link #fallbackValue()} which returns a safe default.
     */
    @Fallback(fallbackMethod = "fallbackValue")
    @Retry(maxRetries = 2)
    public String fetchWithFallback()
    {
        throw new RuntimeException("Service unavailable");
    }

    public String fallbackValue()
    {
        return "default-value (from fallback)";
    }

    /**
     * Must complete within 2 000 ms — returns immediately so it succeeds.
     */
    @Timeout(2000)
    public String fetchWithTimeout()
    {
        return "Completed within timeout";
    }

    /**
     * Circuit breaker trips after 50 % failure ratio in a window of 4 calls,
     * then stays open for 5 000 ms before allowing a probe request.
     */
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5,
            delay = 5000, successThreshold = 2)
    public String fetchWithCircuitBreaker()
    {
        return "Circuit closed — call succeeded";
    }
}

