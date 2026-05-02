package com.guicedee.examples.persistence.mongodb;

import com.guicedee.persistence.implementations.mongodb.MongoConnectionInfo;
import com.guicedee.persistence.implementations.mongodb.MongoModule;

/**
 * Example MongoModule that connects to a local MongoDB instance.
 * <p>
 * Connection details are resolved from environment variables with sensible defaults:
 * <ul>
 *   <li>{@code MONGO_URL} — connection string (default: {@code mongodb://localhost:27017})</li>
 *   <li>{@code MONGO_DB} — database name (default: {@code exampledb})</li>
 * </ul>
 * <p>
 * Register this module in {@code module-info.java}:
 * <pre>{@code
 * provides IGuiceModule with ExampleMongoModule;
 * }</pre>
 */
public class ExampleMongoModule extends MongoModule<ExampleMongoModule> {

    @Override
    protected MongoConnectionInfo getMongoConnectionInfo() {
        String connectionString = System.getProperty("MONGO_URL",
                System.getenv().getOrDefault("MONGO_URL", "mongodb://localhost:27017"));
        String databaseName = System.getProperty("MONGO_DB",
                System.getenv().getOrDefault("MONGO_DB", "exampledb"));

        return new MongoConnectionInfo()
                .setName("example")
                .setConnectionString(connectionString)
                .setDatabaseName(databaseName)
                .setDefaultConnection(true);
    }
}

