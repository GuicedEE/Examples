package com.guicedee.examples.persistence.basic;

import com.guicedee.persistence.db.DatabaseModule;
import com.guicedee.persistence.db.ConnectionBaseInfo;
import com.guicedee.persistence.implementations.postgres.PostgresConnectionBaseInfo;
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
        return new PostgresConnectionBaseInfo()
                .setServerName("localhost")
                .setPort("5432")
                .setDatabaseName("exampledb")
                .setUsername("exampleuser")
                .setPassword("examplepassword")
                ;
    }
}
