module com.guicedee.examples.persistence.mysql {
	requires transitive com.guicedee.persistence;

	exports com.guicedee.examples.persistence.mysql;
	exports com.guicedee.examples.persistence.mysql.entities;

	opens com.guicedee.examples.persistence.mysql to com.google.guice;
	opens com.guicedee.examples.persistence.mysql.entities to org.hibernate.orm.core, tools.jackson.databind;

	provides com.guicedee.client.services.lifecycle.IGuiceModule
			with com.guicedee.examples.persistence.mysql.ExampleDatabaseModule;
}

