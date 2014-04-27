package edu.wctc.spring.boot.rest.demo1.service;

import edu.wctc.spring.boot.rest.demo1.domain.Hotel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    
    List<Hotel> findByNameContaining(@Param("name") String name);
	
}
