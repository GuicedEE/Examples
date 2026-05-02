module com.guicedee.examples.faulttolerance.basic {
    requires transitive com.guicedee.faulttolerance;

    opens com.guicedee.examples.faulttolerance.basic to com.google.guice, com.guicedee.client;
}
