package com.guicedee.examples.persistence.mysql;

import com.guicedee.persistence.db.DatabaseModule;
import com.guicedee.persistence.db.ConnectionBaseInfo;
import com.guicedee.persistence.implementations.mysql.MySqlConnectionBaseInfo;
import org.hibernate.jpa.boot.spi.PersistenceUnitDescriptor;

import java.util.Properties;

/**
 * DatabaseModule subclass pointing to the "exampledb" persistence unit using MySQL.
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
        return new MySqlConnectionBaseInfo()
                .setServerName("localhost")
                .setPort("3306")
                .setDatabaseName("exampledb")
                .setUsername("exampleuser")
                .setPassword("examplepassword")
                ;
    }
}
