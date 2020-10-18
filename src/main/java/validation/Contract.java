package validation;

import notification.Notifiable;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contract extends Notifiable {

    public Contract required() {
        return this;
    }

    /* String validation */

    public Contract isNotNullOrEmpty(String value, String property, String message) {
        if (!StringUtils.isEmpty(value)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotNullOrWhiteSpace(String value, String property, String message) {
        if (StringUtils.isBlank(value) || StringUtils.isEmpty(value)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNullOrEmpty(String value, String property, String message) {
        if (StringUtils.isEmpty(value)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract hasMinLen(String value, int min, String property, String message) {
        if (StringUtils.isEmpty(value) || value.length() < min) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract hasMaxLen(String value, int max, String property, String message) {
        if (StringUtils.isEmpty(value) || value.length() > max) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract hasLen(String value, int length, String property, String message) {
        if (StringUtils.isEmpty(value) || value.length() != length) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract contains(String value, String text, String property, String message) {
        if (StringUtils.isEmpty(value) || value.contains(text)) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isEmail(String email, String property, String message) {

        String emailPattern = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        return matcher(email, emailPattern, property, message);
    }

    public Contract isEmailOrEmpty(String email, String property, String message) {
        if (StringUtils.isEmpty(email)) {
            return this;
        }
        return isEmail(email, property, message);
    }

    public Contract isUrl(String url, String property, String message) {

        String urlPattern = "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";
        return matcher(url, urlPattern, property, message);
    }


    public Contract isUrlOrEmpty(String url, String property, String message) {
        if (StringUtils.isEmpty(url)) {
            return this;
        }
        return isUrl(url, property, message);
    }

    public Contract isDigit(String value, String property, String message) {
        String pattern = "^\\d+$";
        return matcher(value, pattern, property, message);
    }


    public Contract matcher(String text, String pattern, String property, String message) {
        Pattern compile = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compile.matcher(text);

        if (!matcher.find()) {
            addNotification(property, message);
        }

        return this;
    }

    /* Boolean validation */

    public Contract isFalse(boolean value, String property, String message) {
        if (value) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isTrue(boolean value, String property, String message) {
        if (!value) {
            addNotification(property, message);
        }
        return this;
    }

    /* Object validation */

    public Contract isNull(Object object, String property, String message) {
        if (object != null) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotNull(Object object, String property, String message) {
        if (object == null) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract areEquals(Object obj, Object comparer, String property, String message) {
        if (!obj.equals(comparer)) {
            addNotification(property, message);
        }


        return this;
    }

    public Contract areNotEquals(Object obj, Object comparer, String property, String message) {
        if (obj.equals(comparer)) {
            addNotification(property, message);
        }
        return this;
    }

    /* Date  validation */

    public Contract isGreaterThan(Date val, Date comparer, String property, String message) {
        if (val.before(comparer)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterOrEqualsThan(Date val, Date comparer, String property, String message) {
        if (val.before(comparer) || val.equals(comparer)) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isLowerThan(Date val, Date comparer, String property, String message) {
        if (val.after(comparer)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Date val, Date comparer, String property, String message) {
        if (val.after(comparer) || val.equals(comparer)) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isBetween(Date val, Date from, Date to, String property, String message) {
        if (!(val.before(to) && val.after(from))) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNullOrNullable(Date val, String property, String message) {
        if (val == null) {
            addNotification(property, message);
        }

        return this;
    }

    /* Decimal Validation */

    public Contract isGreaterThan(BigDecimal val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer) < 0) {
            addNotification(property, message);
        }


        return this;

    }

    public Contract isGreaterThan(Double val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer.doubleValue()) < 0) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Float val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer.floatValue()) < 0) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Long val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer.longValue()) < 0) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Integer val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer.intValue()) < 0) {
            addNotification(property, message);

        }

        return this;

    }

    public Contract isGreaterOrEqualsThan(BigDecimal val, BigDecimal comparer, String property, String message) {
        if (val.equals(comparer) || val.compareTo(comparer) < 0) {
            addNotification(property, message);
        }


        return this;

    }

    public Contract isGreaterOrEqualsThan(Double val, BigDecimal comparer, String property, String message) {
        if (val.equals(comparer.doubleValue()) || val.compareTo(comparer.doubleValue()) < 0) {
            addNotification(property, message);
        }


        return this;

    }

    public Contract isGreaterOrEqualsThan(Float val, BigDecimal comparer, String property, String message) {
        if (val.equals(comparer.floatValue()) || val.compareTo(comparer.floatValue()) < 0) {
            addNotification(property, message);
        }


        return this;

    }

    public Contract isGreaterOrEqualsThan(Long val, BigDecimal comparer, String property, String message) {
        if (val.equals(comparer.longValue()) || val.compareTo(comparer.longValue()) < 0) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterOrEqualsThan(Integer val, BigDecimal comparer, String property, String message) {
        if (val.equals(comparer.intValue()) || val.compareTo(comparer.intValue()) < 0) {
            addNotification(property, message);
        }


        return this;

    }


    public Contract isLowerThan(BigDecimal val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer) >= 0) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Double val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer.doubleValue()) >= 0) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Float val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer.floatValue()) >= 0) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Long val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer.longValue()) >= 0) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isLowerThan(Integer val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer.intValue()) >= 0) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isLowerOrEqualsThan(BigDecimal val, BigDecimal comparer, String property, String message) {
        if (val.equals(comparer) || val.compareTo(comparer) > 0) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Double val, BigDecimal comparer, String property, String message) {
        if (val.equals(comparer.doubleValue()) || val.compareTo(comparer.doubleValue()) > 0) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Float val, BigDecimal comparer, String property, String message) {
        if (val.equals(comparer.floatValue()) || val.compareTo(comparer.floatValue()) > 0) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Long val, BigDecimal comparer, String property, String message) {
        if (val.equals(comparer.longValue()) || val.compareTo(comparer.longValue()) > 0) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isLowerOrEqualsThan(Integer val, BigDecimal comparer, String property, String message) {
        if (val.equals(comparer.intValue()) || val.compareTo(comparer.intValue()) > 0) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isEquals(BigDecimal val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer) == 0) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Double val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer.doubleValue()) == 0) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Float val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer.floatValue()) == 0) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Long val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer.longValue()) == 0) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isEquals(Integer val, BigDecimal comparer, String property, String message) {
        if (val.compareTo(comparer.intValue()) == 0) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isNotEquals(BigDecimal val, BigDecimal comparer, String property, String message) {
        if (!val.equals(comparer)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Double val, BigDecimal comparer, String property, String message) {
        if (!val.equals(comparer.doubleValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Float val, BigDecimal comparer, String property, String message) {
        if (!val.equals(comparer.floatValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Long val, BigDecimal comparer, String property, String message) {
        if (!val.equals(comparer.longValue())) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isNotEquals(Integer val, BigDecimal comparer, String property, String message) {
        if (!val.equals(comparer.intValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isBetween(BigDecimal val, BigDecimal from, BigDecimal to, String property, String message) {
        if (!(val.compareTo(from) > 0 && val.compareTo(to) < 0)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNullOrNullable(BigDecimal val, String property, String message) {
        if (val == null) {
            addNotification(property, message);
        }
        return this;
    }



    /* Double Validation */

    public Contract isGreaterThan(BigDecimal val, Double comparer, String property, String message) {
        if (val.doubleValue() < comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterThan(Double val, Double comparer, String property, String message) {
        if (val < comparer) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Float val, Double comparer, String property, String message) {
        if (val.doubleValue() < comparer) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Long val, Double comparer, String property, String message) {
        if (val < comparer.longValue()) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Integer val, Double comparer, String property, String message) {
        if (val < comparer.intValue()) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterOrEqualsThan(BigDecimal val, Double comparer, String property, String message) {
        if (val.doubleValue() <= comparer) {
            addNotification(property, message);
        }


        return this;

    }

    public Contract isGreaterOrEqualsThan(Double val, Double comparer, String property, String message) {
        if (val <= comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterOrEqualsThan(Float val, Double comparer, String property, String message) {
        if (val.doubleValue() <= comparer) {
            addNotification(property, message);
        }


        return this;

    }

    public Contract isGreaterOrEqualsThan(Long val, Double comparer, String property, String message) {
        if (val.doubleValue() <= comparer) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterOrEqualsThan(Integer val, Double comparer, String property, String message) {
        if (val.doubleValue() <= comparer) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isLowerThan(BigDecimal val, Double comparer, String property, String message) {
        if (val.doubleValue() > comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Double val, Double comparer, String property, String message) {
        if (val > comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Float val, Double comparer, String property, String message) {
        if (val.doubleValue() > comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Long val, Double comparer, String property, String message) {
        if (val.doubleValue() > comparer) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isLowerThan(Integer val, Double comparer, String property, String message) {
        if (val.doubleValue() > comparer) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isLowerOrEqualsThan(BigDecimal val, Double comparer, String property, String message) {
        if (val.doubleValue() >= comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Double val, Double comparer, String property, String message) {
        if (val >= comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Float val, Double comparer, String property, String message) {
        if (val.doubleValue() >= comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Long val, Double comparer, String property, String message) {
        if (val.doubleValue() >= comparer) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isLowerOrEqualsThan(Integer val, Double comparer, String property, String message) {
        if (val.doubleValue() >= comparer) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isEquals(BigDecimal val, Double comparer, String property, String message) {
        if (comparer.equals(val.doubleValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Double val, Double comparer, String property, String message) {
        if (val.equals(comparer)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Float val, Double comparer, String property, String message) {
        if (val.equals(comparer.floatValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Long val, Double comparer, String property, String message) {
        if (val.equals(comparer.longValue())) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isEquals(Integer val, Double comparer, String property, String message) {
        if (val.equals(comparer.intValue())) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isNotEquals(BigDecimal val, Double comparer, String property, String message) {
        if (!comparer.equals(val.doubleValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Double val, Double comparer, String property, String message) {
        if (!val.equals(comparer)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Float val, Double comparer, String property, String message) {
        if (!comparer.equals(val.doubleValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Long val, Double comparer, String property, String message) {
        if (!val.equals(comparer.longValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Integer val, Double comparer, String property, String message) {
        if (!val.equals(comparer.intValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isBetween(Double val, Double from, Double to, String property, String message) {
        if (!(val.compareTo(from) > 0 && val.compareTo(to) < 0)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNullOrNullable(Double val, String property, String message) {
        if (val == null) {
            addNotification(property, message);
        }
        return this;
    }

    /* Float Validation */

    public Contract isGreaterThan(BigDecimal val, Float comparer, String property, String message) {
        if (val.floatValue() < comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterThan(Double val, Float comparer, String property, String message) {
        if (val < comparer.doubleValue()) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Float val, Float comparer, String property, String message) {
        if (val < comparer) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Long val, Float comparer, String property, String message) {
        if (val < comparer.longValue()) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Integer val, Float comparer, String property, String message) {
        if (val < comparer.intValue()) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterOrEqualsThan(BigDecimal val, Float comparer, String property, String message) {
        if (val.floatValue() <= comparer) {
            addNotification(property, message);
        }


        return this;

    }

    public Contract isGreaterOrEqualsThan(Double val, Float comparer, String property, String message) {
        if (val <= comparer.doubleValue()) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterOrEqualsThan(Float val, Float comparer, String property, String message) {
        if (val <= comparer) {
            addNotification(property, message);
        }


        return this;

    }

    public Contract isGreaterOrEqualsThan(Long val, Float comparer, String property, String message) {
        if (val <= comparer.longValue()) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterOrEqualsThan(Integer val, Float comparer, String property, String message) {
        if (val <= comparer.intValue()) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isLowerThan(BigDecimal val, Float comparer, String property, String message) {
        if (val.floatValue() > comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Double val, Float comparer, String property, String message) {
        if (val > comparer.doubleValue()) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Float val, Float comparer, String property, String message) {
        if (val > comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Long val, Float comparer, String property, String message) {
        if (val > comparer.longValue()) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isLowerThan(Integer val, Float comparer, String property, String message) {
        if (val > comparer.intValue()) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isLowerOrEqualsThan(BigDecimal val, Float comparer, String property, String message) {
        if (val.floatValue() >= comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Double val, Float comparer, String property, String message) {
        if (val >= comparer.doubleValue()) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Float val, Float comparer, String property, String message) {
        if (val >= comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Long val, Float comparer, String property, String message) {
        if (val >= comparer.longValue()) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isLowerOrEqualsThan(Integer val, Float comparer, String property, String message) {
        if (val >= comparer.intValue()) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isEquals(BigDecimal val, Float comparer, String property, String message) {
        if (comparer.equals(val.floatValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Double val, Float comparer, String property, String message) {
        if (val.equals(comparer.doubleValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Float val, Float comparer, String property, String message) {
        if (val.equals(comparer)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Long val, Float comparer, String property, String message) {
        if (val.equals(comparer.longValue())) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isEquals(Integer val, Float comparer, String property, String message) {
        if (val.equals(comparer.intValue())) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isNotEquals(BigDecimal val, Float comparer, String property, String message) {
        if (!comparer.equals(val.floatValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Double val, Float comparer, String property, String message) {
        if (!val.equals(comparer.doubleValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Float val, Float comparer, String property, String message) {
        if (!comparer.equals(val)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Long val, Float comparer, String property, String message) {
        if (!val.equals(comparer.longValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Integer val, Float comparer, String property, String message) {
        if (!val.equals(comparer.intValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isBetween(Float val, Float from, Float to, String property, String message) {
        if (!(val.compareTo(from) > 0 && val.compareTo(to) < 0)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNullOrNullable(Float val, String property, String message) {
        if (val == null) {
            addNotification(property, message);
        }
        return this;
    }

    /* Integer Validation */

    public Contract isGreaterThan(BigDecimal val, Integer comparer, String property, String message) {
        if (val.intValue() < comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterThan(Double val, Integer comparer, String property, String message) {
        if (val.intValue() < comparer) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Float val, Integer comparer, String property, String message) {
        if (val.intValue() < comparer) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Long val, Integer comparer, String property, String message) {
        if (val < comparer.longValue()) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Integer val, Integer comparer, String property, String message) {
        if (val < comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterOrEqualsThan(BigDecimal val, Integer comparer, String property, String message) {
        if (val.intValue() <= comparer) {
            addNotification(property, message);
        }


        return this;

    }

    public Contract isGreaterOrEqualsThan(Double val, Integer comparer, String property, String message) {
        if (val.intValue() <= comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterOrEqualsThan(Float val, Integer comparer, String property, String message) {
        if (val.intValue() <= comparer) {
            addNotification(property, message);
        }


        return this;

    }

    public Contract isGreaterOrEqualsThan(Long val, Integer comparer, String property, String message) {
        if (val.intValue() <= comparer) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterOrEqualsThan(Integer val, Integer comparer, String property, String message) {
        if (val <= comparer) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isLowerThan(BigDecimal val, Integer comparer, String property, String message) {
        if (val.intValue() > comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Double val, Integer comparer, String property, String message) {
        if (val.intValue() > comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Float val, Integer comparer, String property, String message) {
        if (val.intValue() > comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Long val, Integer comparer, String property, String message) {
        if (val > comparer.longValue()) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isLowerThan(Integer val, Integer comparer, String property, String message) {
        if (val > comparer) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isLowerOrEqualsThan(BigDecimal val, Integer comparer, String property, String message) {
        if (val.intValue() >= comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Double val, Integer comparer, String property, String message) {
        if (val >= comparer.doubleValue()) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Float val, Integer comparer, String property, String message) {
        if (val.intValue() >= comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Long val, Integer comparer, String property, String message) {
        if (val >= comparer.longValue()) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isLowerOrEqualsThan(Integer val, Integer comparer, String property, String message) {
        if (val >= comparer.intValue()) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isEquals(BigDecimal val, Integer comparer, String property, String message) {
        if (comparer.equals(val.intValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Double val, Integer comparer, String property, String message) {
        if (val.equals(comparer.doubleValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Float val, Integer comparer, String property, String message) {
        if (val.equals(comparer.floatValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Long val, Integer comparer, String property, String message) {
        if (val.equals(comparer.longValue())) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isEquals(Integer val, Integer comparer, String property, String message) {
        if (val.equals(comparer)) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isNotEquals(BigDecimal val, Integer comparer, String property, String message) {
        if (!comparer.equals(val.intValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Double val, Integer comparer, String property, String message) {
        if (!val.equals(comparer.doubleValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Float val, Integer comparer, String property, String message) {
        if (!comparer.equals(val.intValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Long val, Integer comparer, String property, String message) {
        if (!val.equals(comparer.longValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Integer val, Integer comparer, String property, String message) {
        if (!val.equals(comparer)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isBetween(Integer val, Integer from, Integer to, String property, String message) {
        if (!(val.compareTo(from) > 0 && val.compareTo(to) < 0)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNullOrNullable(Integer val, String property, String message) {
        if (val == null) {
            addNotification(property, message);
        }
        return this;
    }


    /* Long Validation */

    public Contract isGreaterThan(BigDecimal val, Long comparer, String property, String message) {
        if (val.longValue() < comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterThan(Double val, Long comparer, String property, String message) {
        if (val.longValue() < comparer) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Float val, Long comparer, String property, String message) {
        if (val.longValue() < comparer) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterThan(Long val, Long comparer, String property, String message) {
        if (val < comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterThan(Integer val, Long comparer, String property, String message) {
        if (val < comparer.intValue()) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterOrEqualsThan(BigDecimal val, Long comparer, String property, String message) {
        if (val.longValue() <= comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterOrEqualsThan(Double val, Long comparer, String property, String message) {
        if (val.longValue() <= comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isGreaterOrEqualsThan(Float val, Long comparer, String property, String message) {
        if (val.longValue() <= comparer) {
            addNotification(property, message);
        }


        return this;

    }

    public Contract isGreaterOrEqualsThan(Long val, Long comparer, String property, String message) {
        if (val <= comparer) {
            addNotification(property, message);
        }

        return this;

    }

    public Contract isGreaterOrEqualsThan(Integer val, Long comparer, String property, String message) {
        if (val <= comparer.intValue()) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isLowerThan(BigDecimal val, Long comparer, String property, String message) {
        if (val.longValue() > comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Double val, Long comparer, String property, String message) {
        if (val.longValue() > comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Float val, Long comparer, String property, String message) {
        if (val.longValue() > comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerThan(Long val, Long comparer, String property, String message) {
        if (val > comparer) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isLowerThan(Integer val, Long comparer, String property, String message) {
        if (val > comparer.intValue()) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isLowerOrEqualsThan(BigDecimal val, Long comparer, String property, String message) {
        if (val.longValue() >= comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Double val, Long comparer, String property, String message) {
        if (val >= comparer.doubleValue()) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Float val, Long comparer, String property, String message) {
        if (val.longValue() >= comparer) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isLowerOrEqualsThan(Long val, Long comparer, String property, String message) {
        if (val >= comparer) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isLowerOrEqualsThan(Integer val, Long comparer, String property, String message) {
        if (val >= comparer.intValue()) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isEquals(BigDecimal val, Long comparer, String property, String message) {
        if (comparer.equals(val.longValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Double val, Long comparer, String property, String message) {
        if (val.equals(comparer.doubleValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Float val, Long comparer, String property, String message) {
        if (val.equals(comparer.floatValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEquals(Long val, Long comparer, String property, String message) {
        if (val.equals(comparer)) {
            addNotification(property, message);
        }

        return this;
    }

    public Contract isEquals(Integer val, Long comparer, String property, String message) {
        if (val.equals(comparer.intValue())) {
            addNotification(property, message);
        }
        return this;
    }


    public Contract isNotEquals(BigDecimal val, Long comparer, String property, String message) {
        if (!comparer.equals(val.longValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Double val, Long comparer, String property, String message) {
        if (!val.equals(comparer.doubleValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Float val, Long comparer, String property, String message) {
        if (!comparer.equals(val.longValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Long val, Long comparer, String property, String message) {
        if (!val.equals(comparer)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEquals(Integer val, Long comparer, String property, String message) {
        if (!val.equals(comparer.intValue())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isBetween(Long val, Long from, Long to, String property, String message) {
        if (!(val.compareTo(from) > 0 && val.compareTo(to) < 0)) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNullOrNullable(Long val, String property, String message) {
        if (val == null) {
            addNotification(property, message);
        }
        return this;
    }

    /* UUID Validation */

    public Contract areEquals(UUID val, UUID comparer, String property, String message) {
        if (!val.toString().equals(comparer.toString())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract areNotEquals(UUID val, UUID comparer, String property, String message) {
        if (val.toString().equals(comparer.toString())) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isEmpty(UUID val, String property, String message) {
        if (val == null) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNotEmpty(UUID val, String property, String message) {
        if (val != null) {
            addNotification(property, message);
        }
        return this;
    }
}
