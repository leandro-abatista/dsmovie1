package com.leandroamorim.dsmovie1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandroamorim.dsmovie1.dto.MovieDTO;
import com.leandroamorim.dsmovie1.repositories.MovieRepository;
import com.leandroamorim.dsmovie1.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	//composição de componentes
	@Autowired
	private MovieService service;
	@Autowired
	private MovieRepository repository;
	
	@GetMapping
	public Page<MovieDTO> findAll(Pageable pageable){
		return service.findAll(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public MovieDTO findById(@PathVariable Long id){
		return service.findById(id);
	}

}
