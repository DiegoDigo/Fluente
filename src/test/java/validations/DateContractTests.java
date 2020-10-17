package validations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilitary.DateUtils;
import validation.Contract;

import java.util.Calendar;
import java.util.Date;

public class DateContractTests {

    @Test
    @DisplayName("Testando se a data nao é maior que a data de comparação")
    public void isGreaterThan() {
        Date dataAnterior = DateUtils.setDate(2020, Calendar.NOVEMBER, 10);

        Contract date = new Contract()
                .required()
                .isGreaterThan(new Date(), dataAnterior, "string", "string is null");

        Assertions.assertTrue(date.inValid());
        Assertions.assertEquals(1, date.getNotifications().size());
    }


    @Test
    @DisplayName("Testando se a data nao é maior ou igual a data de comparação")
    public void isGreaterOrEqualsThan() {


        Contract date = new Contract()
                .required()
                .isGreaterOrEqualsThan(new Date(), new Date(), "string", "string is null");

        Assertions.assertTrue(date.inValid());
        Assertions.assertEquals(1, date.getNotifications().size());
    }


    @Test
    @DisplayName("Testando se a data recebida é menor q a data de comparação")
    public void isLowerThan() {
        Date dateAfter = DateUtils.setDate(2020, Calendar.NOVEMBER, 15);

        Contract date = new Contract()
                .required()
                .isLowerThan(dateAfter, new Date(), "string", "string is null");

        Assertions.assertTrue(date.inValid());
        Assertions.assertEquals(1, date.getNotifications().size());
    }

    @Test
    @DisplayName("Testando se a data recebida é menor ou igual a data de comparação")
    public void isLowerOrEqualsThan_igual() {

        Contract date = new Contract()
                .required()
                .isLowerOrEqualsThan(new Date(), new Date(), "string", "string is null");

        Assertions.assertTrue(date.inValid());
        Assertions.assertEquals(1, date.getNotifications().size());
    }

    @Test
    @DisplayName("Testando se a data recebida é menor a data de comparação")
    public void isLowerOrEqualsThan_menor() {

        Date dateAfter = DateUtils.setDate(2020, Calendar.NOVEMBER, 15);

        Contract date = new Contract()
                .required()
                .isLowerOrEqualsThan(dateAfter, new Date(), "string", "string is null");

        Assertions.assertTrue(date.inValid());
        Assertions.assertEquals(1, date.getNotifications().size());
    }

    @Test
    @DisplayName("Testando se a data esta fora do periodo")
    public void isBetween() {

        Date dataToday = DateUtils.setDate(2020, Calendar.OCTOBER, 15);
        Date dateFrom = DateUtils.setDate(2020, Calendar.OCTOBER, 16);
        Date dateTo = DateUtils.setDate(2020, Calendar.OCTOBER, 20);


        Contract date = new Contract()
                .required()
                .isBetween(dataToday,dateFrom, dateTo, "string", "string is null");

        Assertions.assertTrue(date.inValid());
        Assertions.assertEquals(1, date.getNotifications().size());
    }

    @Test
    @DisplayName("Testando se a data e nulla")
    public void isNullOrNullable() {
        Contract date = new Contract()
                .required()
                .isNullOrNullable((Date) null, "string", "string is null");

        Assertions.assertTrue(date.inValid());
        Assertions.assertEquals(1, date.getNotifications().size());
    }

}
