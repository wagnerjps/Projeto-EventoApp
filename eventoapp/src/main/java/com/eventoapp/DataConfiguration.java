package com.eventoapp;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
public class DataConfiguration {
	
	/***
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();		//Criação do objeto dataSource para conexão ao banco
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");				//Setando o drive para conexão ao banco
		dataSource.setUrl("jdbc:mysql://localhost:3306/eventoapp?useTimezone=true&serverTimezone=UTC");	//Setando a URl de conexão
		dataSource.setUsername("wagner");										//Setando o usuário de conexão
		dataSource.setPassword("Wa@103719#Ki");									//Setando a senha de conexão
		return dataSource;														//Retornando o objeto dataSource
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();	//Criação do objeto Adapter para conexão Hibernate
		adapter.setDatabase(Database.MYSQL);									//Setando o tipo de base
		adapter.setShowSql(true);												//Autorizando a visualização pelo console
		adapter.setGenerateDdl(true);											//Permissão para Hibernate crie as tabelas
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");		//Setando o dialeto utilizado
		adapter.setPrepareConnection(true);										//Autorizando a conexão automaticamente
		return adapter;															//Retornando o objeto Adapter
	}
	
	***/
	
    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));
        
        //String Url = "postgres://wzicklktoyutes:b1cf60b24db3351dbe1ae1a6eca1598657c97a6f8de14804271827fe002debed@ec2-18-213-176-229.compute-1.amazonaws.com:5432/d4ocb5mdd6hqp7";

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
       //String driver = "org.postgresql.Driver";
        
        BasicDataSource basicDataSource = new BasicDataSource();
        //basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        //basicDataSource.setUrl(Url);
        
        
        	return basicDataSource;
    }
}
