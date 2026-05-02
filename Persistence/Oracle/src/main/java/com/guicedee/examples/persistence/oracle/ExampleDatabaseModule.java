package com.guicedee.examples.persistence.oracle;

import com.guicedee.persistence.db.DatabaseModule;
import com.guicedee.persistence.db.ConnectionBaseInfo;
import com.guicedee.persistence.implementations.oracle.OracleConnectionBaseInfo;
import org.hibernate.jpa.boot.spi.PersistenceUnitDescriptor;

import java.util.Properties;

/**
 * DatabaseModule subclass pointing to the "exampledb" persistence unit using Oracle.
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
        return new OracleConnectionBaseInfo()
                .setServerName("localhost")
                .setPort("1521")
                .setDatabaseName("FREEPDB1")
                .setUsername("exampleuser")
                .setPassword("examplepassword")
                ;
    }
}
