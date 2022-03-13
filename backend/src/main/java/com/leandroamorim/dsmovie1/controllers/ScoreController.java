package com.leandroamorim.dsmovie1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandroamorim.dsmovie1.dto.MovieDTO;
import com.leandroamorim.dsmovie1.dto.ScoreDTO;
import com.leandroamorim.dsmovie1.repositories.MovieRepository;
import com.leandroamorim.dsmovie1.services.MovieService;
import com.leandroamorim.dsmovie1.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO){
		MovieDTO movieDTO = scoreService.saveScore(scoreDTO);
		return movieDTO;
	}

}
