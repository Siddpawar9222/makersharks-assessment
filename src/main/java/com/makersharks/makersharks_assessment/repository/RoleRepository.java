package com.makersharks.makersharks_assessment.repository;


import com.makersharks.makersharks_assessment.model.ERole;
import com.makersharks.makersharks_assessment.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);
}
