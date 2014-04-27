package edu.wctc.spring.boot.rest.demo1.service;

import edu.wctc.spring.boot.rest.demo1.domain.Hotel;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {
    
    List<Hotel> findByNameContaining(@Param("name") String name);
	
}
