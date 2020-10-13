package validation;

import notification.Notifiable;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contract extends Notifiable {

    public Contract required() {
        return this;
    }

    /* String validation */

    public Contract isNotNullOrEmpty(String value, String property, String message) {
        if (StringUtils.isEmpty(value)) {
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
        if (!StringUtils.isEmpty(value)) {
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
        if (!obj.equals(comparer))
            addNotification(property, message);

        return this;
    }

    public Contract areNotEquals(Object obj, Object comparer, String property, String message) {
        if (obj.equals(comparer))
            addNotification(property, message);

        return this;
    }

    /* Date  validation */

    public Contract isGreaterThan(Date val, Date comparer, String property, String message) {
        if (val.before(comparer))
            addNotification(property, message);

        return this;
    }

    public Contract isGreaterOrEqualsThan(Date val, Date comparer, String property, String message) {
        if (val.before(comparer) || val.equals(comparer))
            addNotification(property, message);

        return this;
    }

    public Contract isLowerThan(Date val, Date comparer, String property, String message) {
        if (val.after(comparer))
            addNotification(property, message);

        return this;
    }

    public Contract isLowerOrEqualsThan(Date val, Date comparer, String property, String message) {
        if (val.after(comparer) || val.equals(comparer))
            addNotification(property, message);

        return this;
    }

    public Contract isBetween(Date val, Date from, Date to, String property, String message) {
        if (!(val.before(to) && val.after(from))) {
            addNotification(property, message);
        }
        return this;
    }

    public Contract isNullOrNullable(Date val, String property, String message)
    {
        if (val == null)
            addNotification(property, message);

        return this;
    }
}
