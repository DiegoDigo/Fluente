package notification;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validation.Contract;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NotificationTest extends Notifiable {

    private String property;
    private String message;
    private List<Notification> notifications;
    private Notification notification;

    @BeforeEach
    public void init() {
        this.property = "Test";
        this.message = "Testing";

        this.notification = new Notification(property, message);

        this.notifications = Stream.of("1", "2")
                .map(index -> new Notification(String.format("Teste %s", index), String.format("Testing %s", index)))
                .collect(Collectors.toList());


    }

    @Test
    public void adicionandoNotificacaoPorPropredade() {
        addNotification(property, message);
        Assertions.assertTrue(inValid());
        Assertions.assertEquals(1, getNotifications().size());
    }

    @Test
    public void validandoListaSemNotificacoes() {
        Assertions.assertTrue(valid());
        Assertions.assertEquals(0, getNotifications().size());
    }

    @Test
    public void adicionandoNotificacaoPelaClasseNotification() {
        addNotification(notification);
        Assertions.assertTrue(inValid());
        Assertions.assertEquals(1, getNotifications().size());
    }

    @Test
    public void adicionandoNotificacoesPelaClasseNotification() {
        addNotifications(notifications);
        Assertions.assertTrue(inValid());
        Assertions.assertEquals(2, getNotifications().size());
    }

    @Test
    public void adicionandoNotificacoes() {
        addNotifications(
                new Contract()
                        .required()
                        .isEmail("teste@.com", "email", "teste")
                        .isNotNullOrEmpty("", "nome", "teste")
        );
        Assertions.assertTrue(inValid());
        Assertions.assertEquals(2, getNotifications().size());
    }

}
