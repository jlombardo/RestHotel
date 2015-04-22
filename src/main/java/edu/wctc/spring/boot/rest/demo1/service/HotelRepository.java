package edu.wctc.spring.boot.rest.demo1.service;

import edu.wctc.spring.boot.rest.demo1.domain.Hotel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This is a special Spring Data-JPA interface that Spring uses to create
 * an implementation at runtime, which provides all the C.R.U.D. operations
 * and, due to the annotation, RESTful endpoints.
 * 
 * @author Jim Lombardo
 */
@RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    
    List<Hotel> findByNameContaining(@Param("name") String name);
	
}
