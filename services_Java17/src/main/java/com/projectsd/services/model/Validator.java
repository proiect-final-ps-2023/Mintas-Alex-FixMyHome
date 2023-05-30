package com.projectsd.services.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class Validator {

    private String firstNamePattern = "\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+";
    private String lastNamePattern = "\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+";
    private String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private String phoneNumberPattern = "^(\\+4|)?(07[0-8]{1}[0-9]{1}|02[0-9]{2}|03[0-9]{2}){1}?(\\s|\\.|\\-)?([0-9]{3}(\\s|\\.|\\-|)){2}$";

    public void validateUser(User user) {

        Pattern pattern = Pattern.compile(firstNamePattern);
        if (!pattern.matcher(user.getFirstName()).matches()) {
            throw new IllegalArgumentException("User's first name is not valid !");
        }

        pattern = Pattern.compile(lastNamePattern);
        if (!pattern.matcher(user.getLastName()).matches()) {
            throw new IllegalArgumentException("User's last name is not valid !");
        }

        pattern = Pattern.compile(emailPattern);
        if (!pattern.matcher(user.getEmail()).matches()) {
            throw new IllegalArgumentException("User's email is not valid !");
        }

        pattern = Pattern.compile(phoneNumberPattern);
        if (!pattern.matcher(user.getPhoneNumber()).matches()) {
            throw new IllegalArgumentException("User's phone number is not valid !");
        }

        if (Period.between(user.getDateOfBirth(), LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("User is under 18 years old !");
        }
    }
}
