package com.leandroamorim.dsmovie1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandroamorim.dsmovie1.entities.Movie;

/**
 * MovieRepository está herdando o JPARepository
 * @author leandro
 *
 */
public interface MovieRepository extends JpaRepository<Movie, Long>{

	
}
