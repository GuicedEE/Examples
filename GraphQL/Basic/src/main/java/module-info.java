import com.guicedee.vertx.graphql.services.IGraphQLSchemaProvider;
import com.guicedee.examples.graphql.basic.BookSchemaProvider;

module com.guicedee.examples.graphql.basic {
    requires transitive com.guicedee.vertx.graphql;
    requires com.guicedee.guicedinjection;

    exports com.guicedee.examples.graphql.basic;
    opens com.guicedee.examples.graphql.basic to com.google.guice, com.fasterxml.jackson.databind;

    provides IGraphQLSchemaProvider with BookSchemaProvider;
}

