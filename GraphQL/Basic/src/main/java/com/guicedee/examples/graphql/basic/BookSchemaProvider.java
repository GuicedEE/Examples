package com.guicedee.examples.graphql.basic;

import com.guicedee.vertx.graphql.services.IGraphQLSchemaProvider;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import java.util.List;
import java.util.Map;

/**
 * Schema provider that defines a simple Book API with queries and mutations.
 */
public class BookSchemaProvider implements IGraphQLSchemaProvider<BookSchemaProvider>
{
    private static final List<Map<String, Object>> BOOKS = new java.util.ArrayList<>(List.of(
            Map.of("id", "1", "title", "The Hobbit", "author", "J.R.R. Tolkien", "year", 1937),
            Map.of("id", "2", "title", "Dune", "author", "Frank Herbert", "year", 1965),
            Map.of("id", "3", "title", "Neuromancer", "author", "William Gibson", "year", 1984)
    ));

    @Override
    public TypeDefinitionRegistry getTypeDefinitions()
    {
        return new SchemaParser().parse("""
                type Query {
                    books: [Book!]!
                    book(id: ID!): Book
                }

                type Mutation {
                    addBook(title: String!, author: String!, year: Int!): Book!
                }

                type Book {
                    id: ID!
                    title: String!
                    author: String!
                    year: Int!
                }
                """);
    }

    @Override
    public RuntimeWiring.Builder configureWiring(RuntimeWiring.Builder builder)
    {
        return builder
                .type("Query", b -> b
                        .dataFetcher("books", env -> BOOKS)
                        .dataFetcher("book", env -> {
                            String id = env.getArgument("id");
                            return BOOKS.stream()
                                    .filter(book -> book.get("id").equals(id))
                                    .findFirst()
                                    .orElse(null);
                        })
                )
                .type("Mutation", b -> b
                        .dataFetcher("addBook", env -> {
                            String id = String.valueOf(BOOKS.size() + 1);
                            Map<String, Object> newBook = Map.of(
                                    "id", id,
                                    "title", (String) env.getArgument("title"),
                                    "author", (String) env.getArgument("author"),
                                    "year", (int) env.getArgument("year")
                            );
                            BOOKS.add(newBook);
                            return newBook;
                        })
                );
    }
}

