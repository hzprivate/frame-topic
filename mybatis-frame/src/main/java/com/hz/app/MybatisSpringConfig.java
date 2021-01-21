//package com.hz.app;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
///**
// * @author hz
// * @create 2020-11-19
// */
//@Configuration
//@MapperScan("com.hz.dao")
//@Profile("mybatisSpring")
//public class MybatisSpringConfig {
//
//    /**
//     * 公司数据库
//     * @return
//     */
//    @Bean("dataSourceCompany")
//    @Profile("dataSourceCompany")
//    public DataSource dataSourceCompany(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        //公司数据库
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        dataSource.setUrl("jdbc:mysql://xxx.xxx.xxx.xxx:3306/hztest");
//        return dataSource;
//    }
//
//    /**
//     * 家里数据库
//     * @return
//     */
//    @Bean("dataSourceHome")
//    @Profile("dataSourceHome")
//    public DataSource dataSourceHome(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/hztest");
//
//        return dataSource;
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        return factoryBean.getObject();
//    }
//}
