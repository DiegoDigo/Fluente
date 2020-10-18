package validations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.Contract;

public class StringContractTests {

    @Test
    @DisplayName("Teste de texto vazio ou nulo")
    public void isNotNullOrEmpty() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNotNullOrEmpty("teste", "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Teste de email")
    public void isEmail() {
        Contract email = new Contract()
                .required()
                .isEmail("teste@teste", "teste", "teste email valido");
        Assertions.assertTrue(email.inValid());
        Assertions.assertEquals(1, email.getNotifications().size());
    }

    @Test
    @DisplayName("Teste de email vazio")
    public void isEmailOrEmpty() {
        Contract email = new Contract()
                .required()
                .isEmailOrEmpty("teste@teste", "teste", "teste email valido");
        Assertions.assertTrue(email.inValid());
        Assertions.assertEquals(1, email.getNotifications().size());
    }


    @Test
    @DisplayName("Teste de valores com espaço em branco")
    public void isNotNullOrWhiteSpace() {
        Contract email = new Contract()
                .required()
                .isNotNullOrWhiteSpace("  ", "teste", "teste espaço em branco");
        Assertions.assertTrue(email.inValid());
        Assertions.assertEquals(1, email.getNotifications().size());
    }

    @Test
    @DisplayName("Teste de valor deve ser vazio.")
    public void isNullOrEmpty() {
        Contract email = new Contract()
                .required()
                .isNullOrEmpty(null, "teste", "valor deve ser vazio");
        Assertions.assertTrue(email.inValid());
        Assertions.assertEquals(1, email.getNotifications().size());
    }

    @Test
    @DisplayName("Testando o valor minimo do campo")
    public void hasMinLen() {
        Contract email = new Contract()
                .required()
                .hasMinLen("teste", 6, "teste", "valor minimo.");
        Assertions.assertTrue(email.inValid());
        Assertions.assertEquals(1, email.getNotifications().size());
    }


    @Test
    @DisplayName("Testando o valor maximo do campo")
    public void hasMaxLen() {
        Contract email = new Contract()
                .required()
                .hasMaxLen("valor maior de seis", 6, "teste", "valor maior de seis");
        Assertions.assertTrue(email.inValid());
        Assertions.assertEquals(1, email.getNotifications().size());
    }

    @Test
    @DisplayName("Testando o valor exato do campo")
    public void hasLen() {
        Contract email = new Contract()
                .required()
                .hasLen("valor maior de seis", 6, "teste", "valor exato");
        Assertions.assertTrue(email.inValid());
        Assertions.assertEquals(1, email.getNotifications().size());
    }

    @Test
    @DisplayName("Testando se valor contem um texto")
    public void contains() {
        Contract email = new Contract()
                .required()
                .contains("valor_contem under line", "_", "teste", "valor exato");
        Assertions.assertTrue(email.inValid());
        Assertions.assertEquals(1, email.getNotifications().size());
    }

    @Test
    @DisplayName("Testando se e url")
    public void isUrl() {
        Contract email = new Contract()
                .required()
                .isUrl("teste", "teste", "valor exato");
        Assertions.assertTrue(email.inValid());
        Assertions.assertEquals(1, email.getNotifications().size());
    }

    @Test
    @DisplayName("Testando se e url ou vazio")
    public void isUrlOrEmpty() {
        Contract email = new Contract()
                .required()
                .isUrlOrEmpty("teste", "teste", "valor exato");
        Assertions.assertTrue(email.inValid());
        Assertions.assertEquals(1, email.getNotifications().size());
    }

    @Test
    @DisplayName("Testando se e digito")
    public void isDigit() {
        Contract digit = new Contract()
                .required()
                .isDigit("teste", "teste", "valor exato");
        Assertions.assertTrue(digit.inValid());
        Assertions.assertEquals(1, digit.getNotifications().size());
    }
}
