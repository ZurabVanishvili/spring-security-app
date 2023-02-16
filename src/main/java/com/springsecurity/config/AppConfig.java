package com.springsecurity.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Objects;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.springsecurity")
@PropertySource(("classpath:persistenance-derby.properties"))
public class AppConfig {

    @Autowired
    private Environment env;

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;

    }

    @Bean
    public DataSource securityDataSource(){
        ComboPooledDataSource dataSource =
                new ComboPooledDataSource();

        try {
            dataSource.setDriverClass(env.getProperty("jdbc.driver"));

        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        logger.info(">>>jdbc url: "+env.getProperty("jdbc.url"));


        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        dataSource.setInitialPoolSize(
                getIntProperty("connection.pool.initialPoolSize")
        );
        dataSource.setMinPoolSize(
                getIntProperty("connection.pool.minPoolSize")
        );
        dataSource.setMaxPoolSize(
                getIntProperty("connection.pool.maxPoolSize")
        );
        dataSource.setMaxIdleTime(
                getIntProperty("connection.pool.maxIdleTime")
        );
        return dataSource;
    }


    private int getIntProperty(String name){
        return Integer.parseInt(Objects.requireNonNull(env.getProperty(name)));
    }


}
