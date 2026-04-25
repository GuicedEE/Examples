module com.guicedee.examples.restclient.basic {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.rest.client;

	exports com.guicedee.examples.restclient.basic;
	opens com.guicedee.examples.restclient.basic to com.google.guice, com.guicedee.rest.client, com.fasterxml.jackson.databind;
}

