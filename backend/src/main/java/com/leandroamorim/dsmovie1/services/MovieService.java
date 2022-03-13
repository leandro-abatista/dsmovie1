package com.leandroamorim.dsmovie1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leandroamorim.dsmovie1.dto.MovieDTO;
import com.leandroamorim.dsmovie1.entities.Movie;
import com.leandroamorim.dsmovie1.repositories.MovieRepository;

@Service//componente do sistema spring
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)//método de leitura
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = repository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x)); 
		return page;
		
	}
	
	@Transactional(readOnly = true)//método de leitura
	public MovieDTO findById(Long id) {
		Movie result = repository.findById(id).get();
		//convertendo o Movie em MovieDTO
		MovieDTO dtoMovie = new MovieDTO(result); 
		return dtoMovie;
		
	}
}
