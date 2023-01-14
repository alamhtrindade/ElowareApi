package com.eloworks.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eloworks.crm.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long>{
 
    
}
