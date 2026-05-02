package com.guicedee.examples.persistence.mongodb;

import com.guicedee.client.IGuiceContext;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates MongoDB document storage with the Vert.x MongoClient inside GuicedEE.
 * <p>
 * This example:
 * <ol>
 *   <li>Boots the GuicedEE context (which discovers and installs {@link ExampleMongoModule})</li>
 *   <li>Injects the {@link MongoClient}</li>
 *   <li>Saves a document to the "books" collection</li>
 *   <li>Queries the collection and prints the results</li>
 * </ol>
 * <p>
 * <strong>Prerequisites:</strong> A running MongoDB instance at {@code mongodb://localhost:27017}
 * (or set the {@code MONGO_URL} environment variable).
 */
public class MongoDBExample {

    @Inject
    private MongoClient mongoClient;

    public void run() {
        // Save a document
        JsonObject book = new JsonObject()
                .put("title", "The Hobbit")
                .put("author", "J. R. R. Tolkien")
                .put("year", 1937);

        mongoClient.save("books", book).onComplete(saveResult -> {
            if (saveResult.succeeded()) {
                System.out.println("✅ Saved book with id: " + saveResult.result());

                // Find all books
                mongoClient.find("books", new JsonObject()).onComplete(findResult -> {
                    if (findResult.succeeded()) {
                        System.out.println("📚 Books in collection:");
                        for (JsonObject doc : findResult.result()) {
                            System.out.println("  - " + doc.getString("title")
                                    + " by " + doc.getString("author")
                                    + " (" + doc.getInteger("year") + ")");
                        }
                    } else {
                        System.err.println("❌ Find failed: " + findResult.cause().getMessage());
                    }
                });
            } else {
                System.err.println("❌ Save failed: " + saveResult.cause().getMessage());
            }
        });
    }

    public static void main(String[] args) {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.persistence.mongodb");
        IGuiceContext.instance().inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("MongoDB example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        MongoDBExample example = IGuiceContext.get(MongoDBExample.class);
        example.run();
    }
}

