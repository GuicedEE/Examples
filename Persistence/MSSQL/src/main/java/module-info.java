module com.guicedee.examples.persistence.mssql {
	requires transitive com.guicedee.persistence;

	exports com.guicedee.examples.persistence.mssql;
	exports com.guicedee.examples.persistence.mssql.entities;

	opens com.guicedee.examples.persistence.mssql to com.google.guice;
	opens com.guicedee.examples.persistence.mssql.entities to org.hibernate.orm.core, tools.jackson.databind;

	provides com.guicedee.client.services.lifecycle.IGuiceModule
			with com.guicedee.examples.persistence.mssql.ExampleDatabaseModule;
}

