package com.borges.wallet.wallet.service.impl;

import com.borges.wallet.wallet.entity.User;
import com.borges.wallet.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements com.borges.wallet.wallet.service.UserService {
    @Autowired
    UserRepository repository;

    @Override
    public User save(User u) {
        return repository.save(u);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmailEquals(email);
    }
}
