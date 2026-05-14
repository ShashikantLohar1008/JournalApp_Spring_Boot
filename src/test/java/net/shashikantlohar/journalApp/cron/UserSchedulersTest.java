package net.shashikantlohar.journalApp.cron;

import net.shashikantlohar.journalApp.entity.JournalEntry;
import net.shashikantlohar.journalApp.entity.User;
import net.shashikantlohar.journalApp.enums.Sentiment;
import net.shashikantlohar.journalApp.model.SentimentData;
import net.shashikantlohar.journalApp.repository.UserRepositoryImpl;
import net.shashikantlohar.journalApp.scheduler.UserScheduler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserSchedulersTest {

    @Mock
    private UserRepositoryImpl userRepository;

    @Mock
    private KafkaTemplate<String, SentimentData> kafkaTemplate;

    @InjectMocks
    private UserScheduler userScheduler;

    @Test
    public void testFetchUsersAndSendSaMail(){
        JournalEntry positiveEntry = new JournalEntry();
        positiveEntry.setDate(LocalDateTime.now().minusDays(1));
        positiveEntry.setSentiment(Sentiment.HAPPY);
        User user = User.builder()
                .userName("ram")
                .password("secret")
                .email("ram@example.com")
                .journalEntries(Collections.singletonList(positiveEntry))
                .build();
        when(userRepository.getUserForSA()).thenReturn(Collections.singletonList(user));

        userScheduler.fetchUsersAndSendSaMail();

        verify(kafkaTemplate).send(eq("weekly-sentiments"), eq("ram@example.com"), any(SentimentData.class));
    }
}
