package com.guicedee.examples.graphql.basic;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates a GraphQL server with GuicedEE.
 * After bootstrap, endpoints available:
 * <ul>
 *   <li>POST /graphql — GraphQL queries and mutations</li>
 *   <li>WS /graphql — GraphQL subscriptions (graphql-transport-ws)</li>
 * </ul>
 *
 * <p>Example query:</p>
 * <pre>
 * curl -X POST http://localhost:8080/graphql \
 *   -H "Content-Type: application/json" \
 *   -d '{"query": "{ books { title author year } }"}'
 * </pre>
 */
public class GraphQLExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.graphql.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("GraphQL example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
        System.out.println("GraphQL endpoint available at http://localhost:8080/graphql");
        System.out.println();
        System.out.println("Try: curl -X POST http://localhost:8080/graphql -H 'Content-Type: application/json' -d '{\"query\": \"{ books { title author year } }\"}'");
    }
}

