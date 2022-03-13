package com.leandroamorim.dsmovie1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandroamorim.dsmovie1.entities.Score;
import com.leandroamorim.dsmovie1.entities.ScorePK;
import com.leandroamorim.dsmovie1.entities.User;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
