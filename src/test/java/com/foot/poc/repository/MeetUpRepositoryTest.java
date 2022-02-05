package com.foot.poc.repository;


import com.foot.poc.model.MeetUp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MeetUpRepositoryTest {

    @Autowired
    private MeetUpRepository meetUpRepository;

    @Test
    public void testCRUD() {
        assertThat(meetUpRepository.count()).isEqualTo(0);

        MeetUp save1 = meetUpRepository.save(new MeetUp(null, LocalDate.now(), null, null, "a", "b"));
        MeetUp save2 = meetUpRepository.save(new MeetUp(null, LocalDate.now(), null, null, "c", "d"));

        assertThat(save1.getId()).isNotNull();
        assertThat(save2.getId()).isNotNull();
        assertThat(meetUpRepository.count()).isEqualTo(2);

        meetUpRepository.save(new MeetUp(save2.getId(), LocalDate.now(), null, null, "A", "B"));

        Optional<MeetUp> optional = meetUpRepository.findById(save2.getId());
        assertThat(optional.isPresent()).isTrue();
        assertThat(optional.get().getFirstTeam()).isEqualTo("A");
        assertThat(optional.get().getSecondTeam()).isEqualTo("B");

        meetUpRepository.deleteById(save2.getId());
        assertThat(meetUpRepository.count()).isEqualTo(1);
        assertThat(meetUpRepository.existsById(save2.getId())).isFalse();
    }
}
