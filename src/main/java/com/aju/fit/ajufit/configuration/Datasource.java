package com.aju.fit.ajufit.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.aju.fit.ajufit.repository")
public class Datasource {

    @Value("${app.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${app.datasource.username}")
    private String username;
    @Value("${app.datasource.password}")
    private String password;
    @Value("${app.datasource.connector}")
    private String connector;
    @Value("${app.datasource.host}")
    private String host;
    @Value("${app.datasource.port}")
    private String port;
    @Value("${app.datasource.database}")
    private String database;

    @Bean
    public DataSource dataSource() {
        final String url = String.format(
                "%s://%s:%s/%s?createDatabaseIfNotExist=true",
                connector,
                host,
                port,
                database);

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);

        return dataSource;
    }
}
