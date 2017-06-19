package de.sulzer.hr.githubproxy.common;

import de.sulzer.hr.githubproxy.exceptions.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

/**
 * Common validator methods.
 */
@Service
public class Validator {


    /**
     * Validates that given value is not <code>null</code>. Throws given exception if validation failed.
     *
     * @param value    Value to check
     * @param supplier Supplies validation to throw
     * @throws ValidationException If validation failed
     */
    public void isNotNull(Object value, Supplier<ValidationException> supplier) throws ValidationException {
        if (value == null) {
            throw supplier.get();
        }
    }

    public void isNotNull(Object value, ValidationException exception) throws ValidationException {
        if (value == null) {
            throw exception;
        }
    }

    /**
     * Validates that given string value does not exceed the given maximum length.
     * Throws given exception of given type if validation failed.
     *
     * @param value     Value to check
     * @param maxLength Max. length of string
     * @param supplier  Supplies validation to throw
     * @throws ValidationException If validation failed
     */
    public void isWithinLength(String value, int maxLength, Supplier<ValidationException> supplier) throws ValidationException {
        if (StringUtils.length(value) > maxLength) {
            throw supplier.get();
        }
    }


    /**
     * Validates if given value is not blank is defined by commons StringUtils. Throws given validation exception of given type if validation failed.
     * <p>
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank("")        = false
     * StringUtils.isNotBlank(" ")       = false
     * StringUtils.isNotBlank("bob")     = true
     * StringUtils.isNotBlank("  bob  ") = true
     * </p>
     *
     * @param value    Value to check
     * @param supplier Supplies validation to throw
     * @throws ValidationException If validation failed
     */
    public void isNotBlank(String value, Supplier<ValidationException> supplier) throws ValidationException {
        if (StringUtils.isBlank(value)) {
            throw supplier.get();
        }
    }

    /**
     * Validates if given value is a valid integer. Throws given validation exception of given type if validation failed.
     *
     * @param value    Value to check
     * @param supplier Supplies validation to throw
     * @throws ValidationException If validation failed
     */
    public void isInteger(String value, Supplier<ValidationException> supplier) throws ValidationException {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw supplier.get();
        }
    }


    /**
     * Validates if given value is not null and matches given pattern. Throws given validation exception of given type if validation failed.
     *
     * @param value    Value to test
     * @param pattern  Regular expression
     * @param supplier Supplies validation to throw
     * @throws ValidationException If validation failed
     */
    public void matchesPattern(String value, String pattern, Supplier<ValidationException> supplier) throws ValidationException {
        if (value == null || !value.matches(pattern)) {
            throw supplier.get();
        }
    }
}
