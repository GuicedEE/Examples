module com.guicedee.examples.inject.basic {
	requires com.guicedee.guicedinjection;

	exports com.guicedee.examples.inject.basic;
	opens com.guicedee.examples.inject.basic to com.google.guice;
	opens com.guicedee.examples.inject.basic.services to com.google.guice;

	provides com.guicedee.client.services.lifecycle.IGuiceModule
			with com.guicedee.examples.inject.basic.services.AppModule;
	provides com.guicedee.client.services.lifecycle.IGuicePostStartup
			with com.guicedee.examples.inject.basic.services.PostStartupHook;
}

