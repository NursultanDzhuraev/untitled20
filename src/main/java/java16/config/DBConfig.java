package java16.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DBConfig {
    public static EntityManagerFactory getEntityManagerFactory(){
        Properties properties = new Properties();
        properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/task1");
        properties.put(Environment.JAKARTA_JDBC_USER, "postgres");
        properties.put(Environment.JAKARTA_JDBC_PASSWORD, "nurs123");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.SHOW_SQL, true);

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}
