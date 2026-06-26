module com.guicedee.examples.persistence.basic {
	requires transitive com.guicedee.persistence;

	exports com.guicedee.examples.persistence.basic;
	exports com.guicedee.examples.persistence.basic.entities;
	opens com.guicedee.examples.persistence.basic to com.google.guice;
	opens com.guicedee.examples.persistence.basic.entities to org.hibernate.orm.core, tools.jackson.databind;

	provides com.guicedee.client.services.lifecycle.IGuiceModule
			with com.guicedee.examples.persistence.basic.ExampleDatabaseModule;
}
