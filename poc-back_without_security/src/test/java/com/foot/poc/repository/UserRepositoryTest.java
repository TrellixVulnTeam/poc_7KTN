package com.foot.poc.repository;


import com.foot.poc.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCRUD() {
        assertThat(userRepository.count()).isEqualTo(0);

        User save1 = userRepository.save(new User(null, "a", "b", "email", "d", LocalDate.now(), LocalDate.now(), "test1", "f"));

        assertThat(save1.getId()).isNotNull();
        assertThat(userRepository.count()).isEqualTo(1);

        User save2 = userRepository.save(new User(save1.getId(), "A", "B", "email", "d", LocalDate.now(), LocalDate.now(), "test1", "f"));

        Optional<User> optional = userRepository.findById(save2.getId());
        assertThat(optional.isPresent()).isTrue();
        assertThat(optional.get().getFirstName()).isEqualTo("A");

        userRepository.deleteById(optional.get().getId());
        assertThat(userRepository.count()).isEqualTo(0);

    }

    @Test
    public void testFindByEmail() {
        assertThat(userRepository.count()).isEqualTo(0);
        userRepository.save(new User(null, "a", "b", "email", "d", LocalDate.now(), LocalDate.now(), "test1", "f"));
        assertThat(userRepository.findByEmail("email")).isPresent();
        assertThat(userRepository.count()).isEqualTo(1);
    }
}
