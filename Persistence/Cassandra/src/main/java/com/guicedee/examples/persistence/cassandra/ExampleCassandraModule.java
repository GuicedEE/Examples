package com.guicedee.examples.persistence.cassandra;

import com.guicedee.persistence.implementations.cassandra.CassandraConnectionInfo;
import com.guicedee.persistence.implementations.cassandra.CassandraModule;

/**
 * Example CassandraModule that connects to a local Cassandra instance.
 * <p>
 * Connection details are resolved from environment variables with sensible defaults:
 * <ul>
 *   <li>{@code CASSANDRA_HOST} — contact point host (default: {@code localhost})</li>
 *   <li>{@code CASSANDRA_PORT} — contact point port (default: {@code 9042})</li>
 *   <li>{@code CASSANDRA_KEYSPACE} — keyspace name (default: none)</li>
 * </ul>
 */
public class ExampleCassandraModule extends CassandraModule<ExampleCassandraModule> {

    @Override
    protected CassandraConnectionInfo getCassandraConnectionInfo() {
        String host = System.getProperty("CASSANDRA_HOST",
                System.getenv().getOrDefault("CASSANDRA_HOST", "localhost"));
        int port = Integer.parseInt(System.getProperty("CASSANDRA_PORT",
                System.getenv().getOrDefault("CASSANDRA_PORT", "9042")));
        String keyspace = System.getProperty("CASSANDRA_KEYSPACE",
                System.getenv().getOrDefault("CASSANDRA_KEYSPACE", ""));

        CassandraConnectionInfo info = new CassandraConnectionInfo()
                .setName("example")
                .addContactPoint(host, port)
                .setDefaultConnection(true);

        if (!keyspace.isEmpty()) {
            info.setKeyspace(keyspace);
        }

        return info;
    }
}

