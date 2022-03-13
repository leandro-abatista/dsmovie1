package com.leandroamorim.dsmovie1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leandroamorim.dsmovie1.dto.MovieDTO;
import com.leandroamorim.dsmovie1.dto.ScoreDTO;
import com.leandroamorim.dsmovie1.entities.Movie;
import com.leandroamorim.dsmovie1.entities.Score;
import com.leandroamorim.dsmovie1.entities.User;
import com.leandroamorim.dsmovie1.repositories.MovieRepository;
import com.leandroamorim.dsmovie1.repositories.ScoreRepository;
import com.leandroamorim.dsmovie1.repositories.UserRepository;

@Service//componente do sistema spring
public class ScoreService {

	//composição de componentes
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	/**
	 * método para salvar um 
	 * 
	 */
	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDTO) {
		
		User user = userRepository.findByEmail(scoreDTO.getEmail());
		
		if (user == null) {
			user = new User();
			user.setEmail(scoreDTO.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDTO.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		//para cada score dentro do movie 
		//percore todos os scores dentro de um certo filme
		for(Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		//o size pega o tamanho da coleção
		//avg é a média
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		//salva o movie no banco de dados
		movie = movieRepository.save(movie);
		
		//convertendo o movie para MovieDTO
		return new MovieDTO(movie);
	}
	
	
}
