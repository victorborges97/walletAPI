package com.borges.wallet.wallet.service;

import com.borges.wallet.wallet.entity.User;
import com.borges.wallet.wallet.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    private static final String EMAIL = "teste@teste.com";

    @MockBean
    UserRepository repository;

    @Autowired
    UserService service;

    @Before
    public void setUp() {
        BDDMockito.given(repository.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new User()));
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void testFindByEmail() {
        Optional<User> response = service.findByEmail(EMAIL);

        assertTrue(response.isPresent());
    }
}
