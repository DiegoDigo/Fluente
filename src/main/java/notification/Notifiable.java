package notification;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Notifiable {

    private final List<Notification> notifications = new ArrayList<Notification>();


    public void addNotification(String property, String message) {
        notifications.add(new Notification(property, message));
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void addNotifications(Notifiable item) {
        notifications.addAll(item.notifications);
    }

    public void addNotifications(List<Notification> allNotification) {
        notifications.addAll(allNotification);
    }

    public void clear() {
        notifications.clear();
    }

    public boolean valid() {
        return notifications.isEmpty();
    }

    public boolean inValid() {
        return !notifications.isEmpty();
    }

    public List<Notification> getNotifications() {
        return notifications;
    }
}
