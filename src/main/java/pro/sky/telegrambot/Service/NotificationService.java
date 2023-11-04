package pro.sky.telegrambot.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.Model.Notification_task;
import pro.sky.telegrambot.Repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    private final TelegramBot telegramBot;

    public NotificationService(NotificationRepository notificationRepository, TelegramBot telegramBot) {
        this.notificationRepository = notificationRepository;
        this.telegramBot = telegramBot;
    }

    public void sendNotification(LocalDateTime dateTime) {
        List<Notification_task> tasks = notificationRepository.findByExecDate(dateTime);
tasks.forEach(t ->{
    SendResponse response = telegramBot.execute(new SendMessage(t.getChatId(),  t.getText()));
});
    }


}
