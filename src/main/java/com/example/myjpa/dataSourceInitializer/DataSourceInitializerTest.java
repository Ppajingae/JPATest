package com.example.myjpa.dataSourceInitializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class DataSourceInitializerTest {


    @Bean
    public DataSource dataSource(DataSource dataSource){

        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();

        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(new ResourceDatabasePopulator(false, false, null, new ClassPathResource("data.sql")));
        dataSourceInitializer.setEnabled(true);
        dataSourceInitializer.afterPropertiesSet();

        return dataSource;
    }

}
