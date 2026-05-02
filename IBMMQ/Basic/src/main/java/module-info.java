module com.guicedee.examples.ibmmq.basic {
	requires transitive com.guicedee.ibmmq;

	exports com.guicedee.examples.ibmmq.basic;
	opens com.guicedee.examples.ibmmq.basic to com.google.guice, com.guicedee.ibmmq;
}

