module com.guicedee.examples.faulttolerance.basic {
    requires com.guicedee.guicedinjection;
    requires com.guicedee.client;
    requires com.guicedee.faulttolerance;

    opens com.guicedee.examples.faulttolerance.basic to com.google.guice, com.guicedee.client;
}

