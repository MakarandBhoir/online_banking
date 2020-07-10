package com.bank.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	
/*	private DataSource dataSource;

	@Bean
	 @Autowired
	 public PlatformTransactionManager getTransactionManager(EntityManagerFactory emf) throws NamingException
	{
	      JpaTransactionManager jpaTransaction = new JpaTransactionManager();
	      jpaTransaction.setEntityManagerFactory(emf);
	      return jpaTransaction;
	 }
	
	@Bean
	 public LocalContainerEntityManagerFactoryBean getEMF() {
	 
	     LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	     emf.setDataSource(getDataSource());
	     emf.setPersistenceUnitName("JPA-PU");
	   // emf.setJpaVendorAdapter(getHibernateAdapter());
	        Properties jpaProperties = new Properties();
	        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
	        jpaProperties.put("hibernate.show_sql", "true");
	        jpaProperties.put("hibernate.format_sql","false");
	      emf.setJpaProperties(jpaProperties);
	   return emf;
	 }
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ebank_db");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}*/
}
