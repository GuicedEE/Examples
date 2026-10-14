package com.guicedee.examples.persistence.db2;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedinjection.GuiceApplication;
import com.guicedee.examples.persistence.db2.entities.User;
import com.google.inject.Inject;
import org.hibernate.reactive.mutiny.Mutiny;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates reactive JPA persistence with Hibernate Reactive and DB2.
 * Requires a running DB2 database (configure via persistence.xml or env vars).
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

        GuiceApplication.run(() -> {
            IGuiceContext.registerModule("com.guicedee.examples.persistence.db2");
            IGuiceContext.getContext().getConfig().setServiceLoadWithClassPath(true);
        });

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("DB2 persistence example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        PersistenceExample example = IGuiceContext.get(PersistenceExample.class);
        example.createUser();
    }
}

