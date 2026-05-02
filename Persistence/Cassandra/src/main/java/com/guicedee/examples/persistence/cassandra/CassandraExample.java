package com.guicedee.examples.persistence.cassandra;

import com.guicedee.client.IGuiceContext;
import io.vertx.cassandra.CassandraClient;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates Cassandra storage with the Vert.x CassandraClient inside GuicedEE.
 * <p>
 * This example:
 * <ol>
 *   <li>Boots the GuicedEE context (which discovers and installs {@link ExampleCassandraModule})</li>
 *   <li>Injects the {@link CassandraClient}</li>
 *   <li>Creates a keyspace and table</li>
 *   <li>Inserts a row and queries it back</li>
 * </ol>
 * <p>
 * <strong>Prerequisites:</strong> A running Cassandra instance at {@code localhost:9042}
 * (or set the {@code CASSANDRA_HOST} / {@code CASSANDRA_PORT} environment variables).
 */
public class CassandraExample {

    @Inject
    private CassandraClient cassandraClient;

    public void run() {
        // Create keyspace and table, then insert and query
        cassandraClient.execute(
                "CREATE KEYSPACE IF NOT EXISTS example_ks " +
                "WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1}")
            .onComplete(ksResult -> {
                if (ksResult.failed()) {
                    System.err.println("❌ Keyspace creation failed: " + ksResult.cause().getMessage());
                    return;
                }
                System.out.println("✅ Keyspace created");

                cassandraClient.execute(
                    "CREATE TABLE IF NOT EXISTS example_ks.books " +
                    "(id text PRIMARY KEY, title text, author text)")
                    .onComplete(tableResult -> {
                        if (tableResult.failed()) {
                            System.err.println("❌ Table creation failed: " + tableResult.cause().getMessage());
                            return;
                        }
                        System.out.println("✅ Table created");

                        cassandraClient.execute(
                            "INSERT INTO example_ks.books (id, title, author) " +
                            "VALUES ('1', 'The Hobbit', 'J. R. R. Tolkien')")
                            .onComplete(insertResult -> {
                                if (insertResult.failed()) {
                                    System.err.println("❌ Insert failed: " + insertResult.cause().getMessage());
                                    return;
                                }
                                System.out.println("✅ Row inserted");

                                cassandraClient.executeWithFullFetch("SELECT * FROM example_ks.books")
                                    .onComplete(queryResult -> {
                                        if (queryResult.succeeded()) {
                                            System.out.println("📚 Books in Cassandra:");
                                            for (var row : queryResult.result()) {
                                                System.out.println("  - " + row.getString("title")
                                                        + " by " + row.getString("author"));
                                            }
                                        } else {
                                            System.err.println("❌ Query failed: " + queryResult.cause().getMessage());
                                        }
                                    });
                            });
                    });
            });
    }

    public static void main(String[] args) {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.persistence.cassandra");
        IGuiceContext.instance().inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Cassandra example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        CassandraExample example = IGuiceContext.get(CassandraExample.class);
        example.run();
    }
}

