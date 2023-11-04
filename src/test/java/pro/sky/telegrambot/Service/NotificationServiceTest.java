package pro.sky.telegrambot.Service;


import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.telegrambot.Model.Notification_task;
import pro.sky.telegrambot.Repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {
    @InjectMocks
    private NotificationService notificationService;
    @Mock
    private NotificationRepository notificationRepository;
    @Mock
    private TelegramBot telegramBot;
    @Mock
    private Update update;
    @Mock
    private BaseResponse baseResponse;


    @Test
    void sendNotification() {

        Long chatId = 100l;
        String text = "Test task";
        LocalDateTime execDate = LocalDateTime.of(2023, 11, 03, 10, 30);
        Notification_task taskTest = new Notification_task(chatId,text,execDate);




//        when(notificationRepository.findByExecDate(any())).thenReturn(List.of(taskTest));
////        when(telegramBot.execute(any())).thenReturn(text);
////        when(update.message().text()).thenReturn(text);
//
//        notificationService.sendNotification(execDate);
//
//        String expected = notificationRepository.findByExecDate(execDate).toString();
//
//        assertEquals(expected,List.of(taskTest));

//        SendMessage не может быть возвращен методом выполнения()
//        List<Notification_task> tasks = notificationRepository.findByExecDate(dateTime);
//tasks.forEach(t ->{
//    SendResponse response = telegramBot.execute(new SendMessage(t.getChatId(),  t.getText()))
//        Execute() должен возвращать BaseResponse
    }
}