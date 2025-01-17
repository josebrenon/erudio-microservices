package br.com.erudio.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;


@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	 	
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){

    	return service.findAll();
    }
	
	@GetMapping(value="/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findbyId(@PathVariable(value = "id") String id){

    	return service.findId(id);
    }
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person){

    	return service.create(person);
    }
	
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person){

    	return service.update(person);
    }
	
	@DeleteMapping(value="/{id}")
    public void delete(@PathVariable String id){
		service.delete(id);
    }

}





