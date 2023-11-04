package pro.sky.telegrambot.Model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name= "Notification_task")
public class Notification_task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id ;
   private Long chatId ;
   private String  text ;
//   @Column(name = "exec_date")
    private LocalDateTime execDate;

    public Notification_task() {
    }

    public Notification_task( Long chatId, String text, LocalDateTime execDate) {

        this.chatId = chatId;
        this.text = text;
        this.execDate = execDate;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getExecDate() {
        return execDate;
    }

    public void setExecDate(LocalDateTime execDate) {
        this.execDate = execDate;
    }

    @Override
    public String toString() {
        return "Notification_task{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", text='" + text + '\'' +
                ", execData=" + execDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification_task that = (Notification_task) o;
        return Objects.equals(id, that.id) && Objects.equals(chatId, that.chatId) && Objects.equals(text, that.text) && Objects.equals(execDate, that.execDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatId, text, execDate);
    }
}
