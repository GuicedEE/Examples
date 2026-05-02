package com.guicedee.examples.persistence.oracle;

import com.guicedee.client.IGuiceContext;
import com.guicedee.examples.persistence.oracle.entities.User;
import jakarta.inject.Inject;
import org.hibernate.reactive.mutiny.Mutiny;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates reactive JPA persistence with Hibernate Reactive and Oracle.
 * Requires a running Oracle database (configure via persistence.xml or env vars).
 */
public class PersistenceExample
{
    @Inject
    private Mutiny.SessionFactory sessionFactory;

    public void createUser()
    {
        sessionFactory.withTransaction((session, tx) ->
                        session.persist(new User("John Doe", "john@example.com")))
                .subscribe()
                .with(
                        v -> System.out.println("User created successfully"),
                        e -> System.err.println("Error creating user: " + e.getMessage())
                );
    }

    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.persistence.oracle");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Oracle persistence example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        PersistenceExample example = IGuiceContext.get(PersistenceExample.class);
        example.createUser();
    }
}

