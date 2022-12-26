package com.inventory.management.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.inventory.management.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {
}

//public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
//	
////	public AppUser findByUsername(String username);
//
//	@Query("select a from AppUser a where a.email = :email")
//	public <AppUser> AppUser findByEmail(@Param("email")String email);
//	
//	public AppUser findByEmailAndPassword(String email,String password);
//
//}


