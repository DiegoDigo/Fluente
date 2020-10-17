package validations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validation.Contract;

import java.math.BigDecimal;

public class LongContractTests {

    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterThan() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterThan(BigDecimal.ZERO, 10L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterThan_double() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterThan(0.0, 10L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterThan_float() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterThan(0f, 10L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterThan_long() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterThan(0L, 10L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }


    @Test
    @DisplayName("Testa se o valor e maior q o outro ")
    public void isGreaterThan_int() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterThan(0, 10L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @ParameterizedTest
    @DisplayName("Testa se o valor e maior q o outro ")
    @ValueSource(doubles = {
            0.0,
            10.00
    })
    public void isGreaterOrEqualsThan(final double entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterOrEqualsThan(new BigDecimal(entry), 10L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @ParameterizedTest
    @DisplayName("Testa se o valor e maior q o outro ")
    @ValueSource(doubles = {
            0.0,
            10.00
    })
    public void isGreaterOrEqualsThan_double(final double entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterOrEqualsThan(entry, 10L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @ParameterizedTest
    @DisplayName("Testa se o valor e maior q o outro ")
    @ValueSource(floats = {
            0,
            10
    })
    public void isGreaterOrEqualsThan_float(final float entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterOrEqualsThan(entry, 10L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @ParameterizedTest
    @DisplayName("Testa se o valor e maior q o outro ")
    @ValueSource(longs = {
            0,
            10
    })
    public void isGreaterOrEqualsThan_long(final long entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterOrEqualsThan(entry, 10L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }


    @ParameterizedTest
    @DisplayName("Testa se o valor e maior q o outro ")
    @ValueSource(ints = {
            0,
            10
    })
    public void isGreaterOrEqualsThan_int(final int entry) {
        Contract nullOrEmpty = new Contract()
                .required()
                .isGreaterOrEqualsThan(entry, 10L, "string", "string is null");

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
                .isLowerThan(new BigDecimal(entry), 0L, "string", "string is null");

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
                .isLowerThan(entry, 0L, "string", "string is null");

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
                .isLowerThan(entry, 0L, "string", "string is null");

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
                .isLowerThan(entry, 0L, "string", "string is null");

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
                .isLowerThan(entry, 0L, "string", "string is null");

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
                .isLowerOrEqualsThan(new BigDecimal(enrty), 1L, "string", "string is null");

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
                .isLowerOrEqualsThan(entry, 1L, "string", "string is null");

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
                .isLowerOrEqualsThan(entry, 1L, "string", "string is null");

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
                .isLowerOrEqualsThan(entry, 1L, "string", "string is null");

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
                .isLowerOrEqualsThan(entry, 1L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }


    @Test
    @DisplayName("Testa se o valor são iguais")
    public void isEquals() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isEquals(BigDecimal.ONE, 1L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isEquals_double() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isEquals(1.0, 1L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }


    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isEquals_float() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isEquals(1F, 1L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isEquals_Long() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isEquals(1L, 1L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isLowerOrEqualsThan_int() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isEquals(1, 1L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor são iguais")
    public void isNotEquals() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNotEquals(BigDecimal.TEN, 1L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isNotEquals_double() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNotEquals(10.0, 1L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }


    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isNotEquals_float() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNotEquals(10F, 1L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isNotEquals_Long() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNotEquals(10L, 1L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor e menor q o outro ")
    public void isNotEquals_int() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNotEquals(10, 1L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor estao entre ")
    public void isBetween() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isBetween(10L, 0L, 10L, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }

    @Test
    @DisplayName("Testa se o valor estao entre ")
    public void isNullOrNullable() {
        Contract nullOrEmpty = new Contract()
                .required()
                .isNullOrNullable((Long) null, "string", "string is null");

        Assertions.assertTrue(nullOrEmpty.inValid());
        Assertions.assertEquals(1, nullOrEmpty.getNotifications().size());
    }
}
