module com.guicedee.examples.persistence.oracle {
	requires transitive com.guicedee.persistence;

	exports com.guicedee.examples.persistence.oracle;
	exports com.guicedee.examples.persistence.oracle.entities;

	opens com.guicedee.examples.persistence.oracle to com.google.guice;
	opens com.guicedee.examples.persistence.oracle.entities to org.hibernate.orm.core, tools.jackson.databind;

	provides com.guicedee.client.services.lifecycle.IGuiceModule
			with com.guicedee.examples.persistence.oracle.ExampleDatabaseModule;
}

