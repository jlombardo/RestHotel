package edu.wctc.spring.boot.rest.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * This is how Spring Boot starts an application, in this case a
 * web application that uses Spring Data and JPA to automatically create
 * all the C.R.U.D. operations and map them to RESTful endpoints. See
 * the HotelRepository class under the service package.
 * 
 * @author Jim Lombardo
 */
@Configuration
@ComponentScan
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class SampleDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleDataRestApplication.class, args);
	}

}
