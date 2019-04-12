package com.titanic.repository;

import com.titanic.entity.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IPassengerRepository extends PagingAndSortingRepository<Passenger,Integer>{
    Page<Passenger> findAll(Pageable pageable);
    @Query(value = "SELECT * FROM Passenger p WHERE p.name1 LIKE ?1",nativeQuery = true)
    Page<Passenger> findByName1IsLike(String name1, Pageable Pageable);

}
