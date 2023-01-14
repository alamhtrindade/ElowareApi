package com.eloware.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eloware.crm.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long>{
 
    
}
