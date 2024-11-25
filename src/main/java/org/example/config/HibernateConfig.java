package org.example.config;


import com.zaxxer.hikari.HikariConfig;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class HibernateConfig {

    @Autowired
    Environment env;



    @Bean
    @Autowired
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan(new String[]{"org.example.data.entities"});
        factoryBean.setHibernateProperties(hibernateProperties());
        return factoryBean;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(("database.datasource.driver")));
        dataSource.setUrl(env.getRequiredProperty("database.datasource.jdbcUrl"));
        dataSource.setUsername(env.getRequiredProperty("database.datasource.username"));
        dataSource.setPassword(env.getRequiredProperty("database.datasource.password"));
        return dataSource;
    }

//        @Bean
//        public DataSource dataSource() {
//            HikariConfig datasource = new HikariConfig();
//            datasource.setJdbcUrl("spring.datasource.hikari.jdbcUrl");
//            datasource.setUsername("spring.datasource.hikari.username");
//            datasource.setPassword("spring.datasource.hikari.password");
//            datasource.setPoolName("spring.datasource.hikari.poolName");
//            datasource.setMaximumPoolSize(Integer.parseInt("spring.datasource.hikari.maximumPoolSize"));
//            datasource.setConnectionTimeout(Long.parseLong("spring.datasource.hikari.idleTimeout"));
//            datasource.setIdleTimeout(Long.parseLong("spring.datasource.hikari.connectionTimeout"));
//            datasource.setMaxLifetime(Long.parseLong("spring.datasource.hikari.maxLifetime"));
//            return new HikariDataSource(datasource);
//            //TODO : there is no HikariDataSource in spring framwork
//        }



    public Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put(AvailableSettings.SHOW_SQL,"true");
        properties.put(AvailableSettings.FORMAT_SQL,"true");
        properties.put(AvailableSettings.HBM2DDL_AUTO,"update");
        properties.put(AvailableSettings.DIALECT,"org.hibernate.dialect.MySQL55Dialect");

        return properties;

    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(SessionFactory sessionFactory){

        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }


}
