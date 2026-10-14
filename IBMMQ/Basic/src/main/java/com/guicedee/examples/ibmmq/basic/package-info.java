@com.guicedee.vertx.spi.Verticle("ibmmq-example")
@com.guicedee.ibmmq.IBMMQConnectionOptions(
        value = "example-connection",
        host = "localhost",
        port = 1414,
        queueManager = "QM1",
        channel = "DEV.APP.SVRCONN"
)
package com.guicedee.examples.ibmmq.basic;

