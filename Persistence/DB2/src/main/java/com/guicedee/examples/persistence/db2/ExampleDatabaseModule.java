package com.guicedee.examples.persistence.db2;

import com.guicedee.persistence.db.DatabaseModule;
import com.guicedee.persistence.db.ConnectionBaseInfo;
import com.guicedee.persistence.implementations.db2.DB2ConnectionBaseInfo;
import org.hibernate.jpa.boot.spi.PersistenceUnitDescriptor;

import java.util.Properties;

/**
 * DatabaseModule subclass pointing to the "exampledb" persistence unit using DB2.
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
        return new DB2ConnectionBaseInfo()
                .setServerName("localhost")
                .setPort("50000")
                .setDatabaseName("exampledb")
                .setUsername("db2inst1")
                .setPassword("examplepassword")
                ;
    }
}
