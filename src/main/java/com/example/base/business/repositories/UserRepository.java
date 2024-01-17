package com.example.base.business.repositories;

import com.example.base.business.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT distinct e FROM UserEntity e " +
            "WHERE e.status != 0")
    Page<UserEntity> findAll (Pageable pageable);
    @Query(value = "SELECT distinct e FROM UserEntity e " +
            "WHERE e.name like CONCAT('%',:value,'%') "  +
            "OR e.phoneNumber like CONCAT('%',:value,'%') " +
            "OR e.address like CONCAT('%',:value,'%') " +
            "AND e.status != 0")
    Page<UserEntity> search (@Param("value") String value, Pageable pageable);
}
