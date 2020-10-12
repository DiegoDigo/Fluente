package validations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.Contract;

public class BooleanContractTests {

    @Test
    @DisplayName("Teste se nao e falso")
    public void isFalse() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isFalse(true, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Teste se nao e verdadeiro")
    public void isTrue() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isTrue(false, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }
}
