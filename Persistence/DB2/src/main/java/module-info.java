module com.guicedee.examples.persistence.db2 {
	requires transitive com.guicedee.persistence;

	exports com.guicedee.examples.persistence.db2;
	exports com.guicedee.examples.persistence.db2.entities;

	opens com.guicedee.examples.persistence.db2 to com.google.guice;
	opens com.guicedee.examples.persistence.db2.entities to org.hibernate.orm.core, com.fasterxml.jackson.databind;

	provides com.guicedee.client.services.lifecycle.IGuiceModule
			with com.guicedee.examples.persistence.db2.ExampleDatabaseModule;
}

