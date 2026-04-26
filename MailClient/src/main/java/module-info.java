module com.guicedee.examples.mailclient {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.mailclient;

	exports com.guicedee.examples.mailclient;
	opens com.guicedee.examples.mailclient to com.google.guice;
}

