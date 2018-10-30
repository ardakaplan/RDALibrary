package com.ardakaplan.rdalibrary.ui.views.fontables.edittexts.validators;

import java.util.regex.Pattern;

public class EMailValidator implements Validator {

    private String errorText;

    public EMailValidator(String errorText) {
        this.errorText = errorText;
    }

    @Override
    public boolean validate(String text) {

        return Pattern.compile(".+@.+\\.[a-z]+").matcher(text).matches();
    }

    @Override
    public String getErrorMessage() {
        return errorText;
    }
}
