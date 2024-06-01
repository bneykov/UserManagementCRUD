package com.personal.userManagement_app.repositories;

import com.personal.userManagement_app.model.entity.UserEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    @Query("select u from UserEntity u where u.firstName like %?1% or u.lastName like %?1% or u.email like %?1% or u.phoneNumber like %?1%" +
            "or CONCAT( FUNCTION('YEAR', u.dateOfBirth), '' ) LIKE %?1% or CONCAT(FUNCTION('MONTH', u.dateOfBirth),'') LIKE %?1%" +
            "or CONCAT(FUNCTION('DAY', u.dateOfBirth), '') LIKE %?1%")
    List<UserEntity> searchUsers(String keyword, Sort sort);

}
