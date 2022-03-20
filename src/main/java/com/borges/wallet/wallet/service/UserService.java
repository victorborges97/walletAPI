package com.borges.wallet.wallet.service;

import com.borges.wallet.wallet.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User u);

    Optional<User> findByEmail(String email);
}
