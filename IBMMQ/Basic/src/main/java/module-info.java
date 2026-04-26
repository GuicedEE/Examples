module com.guicedee.examples.ibmmq.basic {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.ibmmq;

	exports com.guicedee.examples.ibmmq.basic;
	opens com.guicedee.examples.ibmmq.basic to com.google.guice, com.guicedee.ibmmq;
}

