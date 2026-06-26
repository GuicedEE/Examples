module com.guicedee.examples.restclient.basic {

	requires transitive com.guicedee.rest.client;

	exports com.guicedee.examples.restclient.basic;
	opens com.guicedee.examples.restclient.basic to com.google.guice, com.guicedee.rest.client, tools.jackson.databind;
}

