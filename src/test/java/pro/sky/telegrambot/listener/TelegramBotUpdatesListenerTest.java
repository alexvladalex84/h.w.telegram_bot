package pro.sky.telegrambot.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pro.sky.telegrambot.Model.Notification_task;
import pro.sky.telegrambot.Repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(MockitoExtension.class)
//@WebMvcTest()
class TelegramBotUpdatesListenerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
    @InjectMocks
    private TelegramBotUpdatesListener telegramBotUpdatesListener;
    @Mock
    private Update update;
    @Mock
    private TelegramBot telegramBot;
    @Mock
    private NotificationRepository notificationRepository;


    @Test
    void processUnit() throws Exception {
//подготовка входных данных
        Long chatId = 100l;
        String text = "Test task";
        LocalDateTime execDate = LocalDateTime.of(2023, 11, 03, 10, 30);
        Notification_task notification = new Notification_task(chatId, text, execDate);

        String START = "/start";

        String messageActual = "Добро пожаловать," + " name " + "! Введите задачу.ПРИМЕР ФОРМАТА : 01.01.2022 20:00 Сдать домашку";

        SendMessage message = new SendMessage(chatId, "Добро пожаловать, " + " name " + " ! Введите задачу.ПРИМЕР ФОРМАТА : 01.01.2022 20:00 Сдать домашку");
        List<Update> updates = new ArrayList<>();

//подготовка ожидаемого результата
//        when(update.message().text()).thenReturn(START);
//        when(telegramBot.execute(any())).thenReturn(message);
        when(notificationRepository.save(any())).thenReturn(notification);

        int expected = telegramBotUpdatesListener.process(updates);
        Notification_task expected1 = notificationRepository.save(notification);

//начало теста S
        assertEquals(expected,-1);
        assertEquals(expected1, notification);
    }






}