package com.hzk.mydap.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = Ds2DataSourceConfig.PACKAGES, sqlSessionFactoryRef = "ds2SqlSessionFactory")
public class Ds2DataSourceConfig {
    static final String PACKAGES = "com.hzk.mydap.mapper.ds2";

    private static final String MAPPER_LOCAL = "classpath:mapper/ds2/*.xml";

    @Bean(name = "ds2DataSource")
    @ConfigurationProperties("custom.datasource.ds2")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "ds2TransactionManager")
    public DataSourceTransactionManager customTransactionManager() {
        return new DataSourceTransactionManager(druidDataSource());
    }


    @Bean(name = "ds2SqlSessionFactory")
    public SqlSessionFactory customSqlSessionFactory(@Qualifier("ds2DataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCAL));
        return sessionFactoryBean.getObject();
    }

}

