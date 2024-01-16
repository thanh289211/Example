package com.example.base.business.repositories;

import com.example.base.business.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Page<UserEntity> findAll (Pageable pageable);
    long count();
    @Query("SELECT distinct e FROM UserEntity e " +
            "WHERE e.name like :value "  +
            "OR e.phoneNumber like :value " +
            "OR e.address like :value")
    Page<UserEntity> search (String value, Pageable pageable);
}
