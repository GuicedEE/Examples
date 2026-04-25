package com.guicedee.examples.persistence.basic;

import com.guicedee.persistence.db.DatabaseModule;
import com.guicedee.persistence.db.ConnectionBaseInfo;
import com.guicedee.persistence.db.ConnectionBaseInfoFactory;
import org.hibernate.jpa.boot.spi.PersistenceUnitDescriptor;

import java.util.Properties;

/**
 * DatabaseModule subclass pointing to the "exampledb" persistence unit.
 * Registered via SPI in module-info.java.
 */
public class ExampleDatabaseModule extends DatabaseModule<ExampleDatabaseModule>
{
    @Override
    protected String getPersistenceUnitName()
    {
        return "exampledb";
    }

    @Override
    protected ConnectionBaseInfo getConnectionBaseInfo(PersistenceUnitDescriptor unit, Properties properties)
    {
        return new com.guicedee.persistence.implementations.postgres.PostgresConnectionBaseInfo()
                .setUsername("exampleuser")
                .setPassword("examplepassword")
                .setDatabaseName("exampledb")
                .setHost("localhost")
                .setPort(5432)
                ;
    }
}

