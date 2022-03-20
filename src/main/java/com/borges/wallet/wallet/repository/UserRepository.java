package com.borges.wallet.wallet.repository;

import com.borges.wallet.wallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailEquals(String email);

}
