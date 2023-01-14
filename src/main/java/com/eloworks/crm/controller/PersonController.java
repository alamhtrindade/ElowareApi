package com.eloworks.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.eloworks.crm.model.Person;
import com.eloworks.crm.repository.IPersonRepository;

@RestController
@RequestMapping("/pessoas")
public class PersonController {
    
    @Autowired
    private IPersonRepository personRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person){

        return personRepository.save(person);

    }


    @GetMapping
    public List<Person> read(){

        return personRepository.findAll();

    }


    @GetMapping(value="/{id}")
    public Optional<Person> read(@PathVariable("id") Long id){
       
        return personRepository.findById(id);

    }


    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Person person){
        
        return  personRepository.findById(id).map(
                    record -> {
                        record.setName(person.getName());
                        record.setBirthdate(person.getBirthdate());

                        Person personUpdate = personRepository.save(record);

                        return ResponseEntity.ok().body(personUpdate);

                    }
                ).orElse(ResponseEntity.notFound().build());

    }


    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity <?> delete(@PathVariable Long id){
        
        return  personRepository.findById(id).map(
                    record -> {
                        personRepository.deleteById(id);
                        return ResponseEntity.ok().build();
                    }
                ).orElse(ResponseEntity.notFound().build());
    }
    

}

