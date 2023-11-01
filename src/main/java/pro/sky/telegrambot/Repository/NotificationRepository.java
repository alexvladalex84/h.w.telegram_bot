package pro.sky.telegrambot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.Model.Notification_task;

@Repository
public interface NotificationRepository extends JpaRepository<Notification_task,Long> {
}
