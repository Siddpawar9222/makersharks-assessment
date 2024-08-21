package com.makersharks.makersharks_assessment.repository;
;
import com.makersharks.makersharks_assessment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

    @Query("SELECT u.id FROM User u WHERE u.username = :username")
    Integer findIdByUsername(@Param("username") String username);
}
