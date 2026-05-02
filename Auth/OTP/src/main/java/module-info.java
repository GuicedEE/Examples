module com.guicedee.examples.auth.otp {
	requires transitive com.guicedee.rest;
	requires transitive io.vertx.auth.otp;

	exports com.guicedee.examples.auth.otp;
	opens com.guicedee.examples.auth.otp to com.google.guice, com.fasterxml.jackson.databind;

	provides com.guicedee.vertx.auth.otp.IOtpAuthenticatorService
			with com.guicedee.examples.auth.otp.InMemoryOtpService;
}
