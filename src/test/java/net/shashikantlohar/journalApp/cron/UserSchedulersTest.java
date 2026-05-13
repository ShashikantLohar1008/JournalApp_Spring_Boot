package net.shashikantlohar.journalApp.cron;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.shashikantlohar.journalApp.scheduler.UserScheduler;

@SpringBootTest
public class UserSchedulersTest {

    @Autowired
    private UserScheduler userScheduler;


    @Test
    public void testFetchUsersAndSendSaMail(){
        userScheduler.fetchUsersAndSendSaMail();
    }
}
