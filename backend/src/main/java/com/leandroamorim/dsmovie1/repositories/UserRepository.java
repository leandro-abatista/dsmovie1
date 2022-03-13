package com.leandroamorim.dsmovie1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandroamorim.dsmovie1.entities.Score;
import com.leandroamorim.dsmovie1.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	//busca padrão do spring data no banco de dados por email
	User findByEmail(String email);

}
