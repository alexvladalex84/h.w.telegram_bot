package pro.sky.telegrambot.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pro.sky.telegrambot.Service.NotificationService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class Scheduler {
    private final NotificationService notificationService;

    public Scheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
//        @Scheduled(fixedDelay = 1_000l)
//    public void test1() {
//
//        System.out.println("Привет из шидлера");
//    }
//    @Scheduled(fixedDelay = 1_000l)
    @Scheduled(cron = "0 0/1 * * * *" )
    public void notification() {
        notificationService.sendNotification(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
    }

}
