import com.guicedee.client.services.lifecycle.IGuiceModule;

module com.guicedee.examples.vertx.redis {
	requires transitive com.guicedee.guicedinjection;
	requires transitive io.vertx.redis.client;

	opens com.guicedee.examples.vertx.redis to com.google.guice, tools.jackson.databind;
	exports com.guicedee.examples.vertx.redis;

	provides IGuiceModule
			with com.guicedee.examples.vertx.redis.ExampleRedisModule;
}
