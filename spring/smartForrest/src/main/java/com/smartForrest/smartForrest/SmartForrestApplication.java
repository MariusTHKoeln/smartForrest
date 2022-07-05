package com.smartForrest.smartForrest;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
public class SmartForrestApplication {

	@Value("${database.url}")
	private String url;

	@Value("${database.user}")
	private String user;

	@Value("${database.pw}")
	private String pw;

	public static void main(String[] args) {
		SpringApplication.run(SmartForrestApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(user);
		config.setPassword(pw);
		config.setPoolName("standard");
//		config.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource");
		config.setDriverClassName("org.h2.Driver");
		config.validate();
		return new HikariDataSource(config);
	}

}
