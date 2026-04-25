module com.guicedee.examples.persistence.basic {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.persistence;
	requires jakarta.persistence;

	exports com.guicedee.examples.persistence.basic;
	exports com.guicedee.examples.persistence.basic.entities;
	opens com.guicedee.examples.persistence.basic to com.google.guice;
	opens com.guicedee.examples.persistence.basic.entities to org.hibernate.orm.core, com.fasterxml.jackson.databind;

	provides com.guicedee.client.services.lifecycle.IGuiceModule
			with com.guicedee.examples.persistence.basic.ExampleDatabaseModule;
}

