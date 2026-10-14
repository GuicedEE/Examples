package com.guicedee.examples.inject.basic.services;

import com.guicedee.client.services.lifecycle.IGuicePostStartup;
import io.smallrye.mutiny.Uni;
import java.util.List;

/**
 * Runs after the Guice injector is created. Demonstrates the IGuicePostStartup lifecycle hook.
 */
public class PostStartupHook implements IGuicePostStartup<PostStartupHook>
{
    @Override
    public List<Uni<Boolean>> postLoad()
    {
        return List.of(Uni.createFrom().item(() -> {
            System.out.println("[PostStartup] GuicedEE injector is ready!");
            return true;
        }));
    }

    @Override
    public Integer sortOrder()
    {
        return Integer.MAX_VALUE;
    }
}

