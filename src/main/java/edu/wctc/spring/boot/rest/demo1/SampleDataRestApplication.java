package edu.wctc.spring.boot.rest.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import javax.servlet.Filter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is how Spring Boot starts an application, in this case a web application
 * that uses Spring Data and JPA to automatically create all the C.R.U.D.
 * operations and map them to RESTful endpoints. See the HotelRepository class
 * under the service package.
 *
 * @author Jim Lombardo
 */
@SpringBootApplication
public class SampleDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleDataRestApplication.class, args);
    }

    @Bean
    public Filter etagFilter() {
        return new ShallowEtagHeaderFilter();
    }
}
