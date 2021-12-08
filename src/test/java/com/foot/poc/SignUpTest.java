package com.foot.poc;


import com.foot.poc.model.User;
import com.foot.poc.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class SignUpTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void signUpTest(){
        User user = new User();
        user.setUserName("Soufiane");
        user.setBirthday(LocalDate.of(1998,07,24));
        user.setPhoneNumber("0760088751");
        user.setEmail("soufiane@gmail.com");
        user.setAddress("2 rue balay");

        userRepository.save(user);

        assertThat(userRepository.findById(user.getUserId())).isNotEmpty();
    }
}
