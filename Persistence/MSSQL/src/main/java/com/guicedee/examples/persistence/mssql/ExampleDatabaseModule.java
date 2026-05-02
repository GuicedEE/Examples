package com.guicedee.examples.persistence.mssql;

import com.guicedee.persistence.db.DatabaseModule;
import com.guicedee.persistence.db.ConnectionBaseInfo;
import com.guicedee.persistence.implementations.sqlserver.SqlServerConnectionBaseInfo;
import org.hibernate.jpa.boot.spi.PersistenceUnitDescriptor;

import java.util.Properties;

/**
 * DatabaseModule subclass pointing to the "exampledb" persistence unit using SQL Server.
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
        return new SqlServerConnectionBaseInfo()
                .setTrustServerCertificate(true)
                .setServerName("localhost")
                .setPort("1433")
                .setDatabaseName("exampledb")
                .setUsername("sa")
                .setPassword("YourStrong!Passw0rd")
                ;
    }
}
