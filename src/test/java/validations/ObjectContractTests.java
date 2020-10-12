package validations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.Contract;

public class ObjectContractTests {

    @Test
    @DisplayName("Testa se o objecto e diferente de nullo")
    public void isNull() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNull("teste", "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o objecto e nullo")
    public void isNotNull() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNotNull(null, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }


    @Test
    @DisplayName("Testa se os objectos são diferentes. ")
    public void areEquals() {
        Contract nullOrEmpty = new Contract()
                .required()
                .areEquals("teste", "teste 2","string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se os objectos são iguais. ")
    public void areNotEquals() {
        Contract nullOrEmpty = new Contract()
                .required()
                .areNotEquals("teste", "teste","string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }
}
