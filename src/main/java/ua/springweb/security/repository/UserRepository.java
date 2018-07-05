package ua.springweb.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.springweb.security.entity.UserEntity;

@Repository
public interface UserRepository 
	extends JpaRepository<UserEntity, Integer>{

	@Query("SELECT u FROM UserEntity u WHERE  u.email = :email")
	UserEntity findUserByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM UserEntity u WHERE  u.email = :email")
	UserEntity findUserForAuthentication(@Param("email") String email);
	
}
