package notification;

import lombok.Getter;

@Getter
public class Notification {

    private String property;
    private String message;

    public Notification(String property, String message) {
        this.property = property;
        this.message = message;
    }
}
