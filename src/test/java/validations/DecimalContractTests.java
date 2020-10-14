package validations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validation.Contract;

import java.math.BigDecimal;

public class DecimalContractTests {

    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterThan() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterThan(BigDecimal.ZERO, BigDecimal.TEN, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterThan_double() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterThan(0.0, BigDecimal.TEN, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterThan_float() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterThan(0f, BigDecimal.TEN, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterThan_long() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterThan(0L, BigDecimal.TEN, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }


    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterThan_int() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterThan(0, BigDecimal.TEN, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterOrEqualsThan() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterOrEqualsThan(BigDecimal.TEN, BigDecimal.TEN, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterOrEqualsThan_double() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterOrEqualsThan(10.0, BigDecimal.TEN, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterOrEqualsThan_float() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterOrEqualsThan(10f, BigDecimal.TEN, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterOrEqualsThan_long() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterOrEqualsThan(10L, BigDecimal.TEN, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }


    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterOrEqualsThan_int() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterOrEqualsThan(10, BigDecimal.TEN, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @ParameterizedTest
    @DisplayName("Testa se o valor e menor q o outro ")
    @ValueSource(doubles = {
            1,
            10
    })
    public void isLowerThan(final double entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isLowerThan(new BigDecimal(entry), BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @ParameterizedTest
    @DisplayName("Testa se o valor e menor q o outro ")
    @ValueSource(doubles = {
            1,
            10
    })
    public void isLowerThan_double(final double entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isLowerThan(entry, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @ParameterizedTest
    @DisplayName("Testa se o valor e menor q o outro ")
    @ValueSource(floats = {
            1,
            10
    })
    public void isLowerThan_float(final float entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isLowerThan(entry, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @ParameterizedTest
    @DisplayName("Testa se o valor e menor q o outro ")
    @ValueSource(longs = {
            1,
            10
    })
    public void isLowerThan_Long(final long entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isLowerThan(entry, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @ParameterizedTest
    @DisplayName("Testa se o valor e menor q o outro ")
    @ValueSource(ints = {
            1,
            10
    })
    public void isLowerThan_int(final int entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isLowerThan(entry, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }


    @ParameterizedTest
    @DisplayName("Testa se o valor e menor q o outro ")
    @ValueSource(doubles = {
            1.0,
            10.0
    })
    public void isLowerOrEqualsThan(final Double enrty) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isLowerOrEqualsThan(new BigDecimal(enrty), BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @ParameterizedTest
    @DisplayName("Testa se o valor e menor q o outro ")
    @ValueSource(doubles = {
            1.0,
            10.0
    })
    public void isLowerOrEqualsThan_double(final Double entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isLowerOrEqualsThan(entry, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }


    @ParameterizedTest
    @DisplayName("Testa se o valor e menor q o outro ")
    @ValueSource(floats = {
            1,
            10
    })
    public void isLowerOrEqualsThan_float(final Float entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isLowerOrEqualsThan(entry, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @ParameterizedTest
    @DisplayName("Testa se o valor e menor q o outro ")
    @ValueSource(longs = {
            1,
            10
    })
    public void isLowerOrEqualsThan_Long(final long entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isLowerOrEqualsThan(entry, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @ParameterizedTest
    @DisplayName("Testa se o valor e menor q o outro ")
    @ValueSource(ints = {
            1,
            10
    })
    public void isLowerOrEqualsThan_int(final int entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isLowerOrEqualsThan(entry, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }


    @Test
    @DisplayName("Testa se o valor são iguais")
    public void isEquals() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isEquals(BigDecimal.ONE, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isEquals_double() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isEquals(1.0, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }


    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isEquals_float() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isEquals(1F, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isEquals_Long() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isEquals(1L, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isLowerOrEqualsThan_int() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isEquals(1, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor são iguais")
    public void isNotEquals() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNotEquals(BigDecimal.TEN, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isNotEquals_double() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNotEquals(10.0, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }


    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isNotEquals_float() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNotEquals(10F, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isNotEquals_Long() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNotEquals(10L, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isNotEquals_int() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNotEquals(10, BigDecimal.ONE, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor estao entre ")
    public void isBetween() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isBetween(BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.TEN, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor estao entre ")
    public void isNullOrNullable() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNullOrNullable((BigDecimal) null, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }
}
