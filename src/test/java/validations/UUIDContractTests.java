package validations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.Contract;

import java.util.UUID;

public class UUIDContractTests {

    @Test
    @DisplayName("uuid nao podem ser diferentes")
    public void areEquals() {
        Contract uuid = new Contract()
                .required()
                .areEquals(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "string", "string is null");

        Assertions.assertTrue(uuid.inValid());
        Assertions.assertEquals(1, uuid.getNotifications().size());
    }

    @Test
    @DisplayName("uuid nao podem ser iguais")
    public void areNotEquals() {
        String uuidIgual = UUID.randomUUID().toString();
        Contract uuid = new Contract()
                .required()
                .areNotEquals(uuidIgual, uuidIgual, "string", "string is null");

        Assertions.assertTrue(uuid.inValid());
        Assertions.assertEquals(1, uuid.getNotifications().size());
    }

    @Test
    @DisplayName("uuid nao pode ser vazio ou nullo")
    public void isEmpty() {
        Contract uuid = new Contract()
                .required()
                .isEmpty(null, "string", "string is null");

        Assertions.assertTrue(uuid.inValid());
        Assertions.assertEquals(1, uuid.getNotifications().size());
    }

    @Test
    @DisplayName("uuid nao pode ser vazio ou nullo")
    public void isNotEmpty() {
        Contract uuid = new Contract()
                .required()
                .isNotEmpty(UUID.randomUUID(), "string", "string is null");

        Assertions.assertTrue(uuid.inValid());
        Assertions.assertEquals(1, uuid.getNotifications().size());
    }
}
