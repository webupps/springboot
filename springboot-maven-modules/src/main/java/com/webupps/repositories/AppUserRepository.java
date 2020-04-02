package com.webupps.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webupps.model.AppUser;

@Transactional
@Repository
public interface AppUserRepository extends CrudRepository<AppUser,Integer>{

	@Query("select c from AppUser c where c.username like concat('%',:username,'%')")
    List<AppUser> findByUserName(@Param("username") String username);
}
