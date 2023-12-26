package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository <T, ID> => T is the entity type, Id is the key.

    // now you will auto suggestions, like findById

}

// JPA is interface
// hibernate is the actual implementation of those functions.

