package com.ardakaplan.rdalibrary.base.ui.views.fontables.edittexts.validators;

/**
 * Created by Arda Kaplan on 30-Oct-18 - 10:54
 */
public interface Validator {

    boolean validate(String text);

    String getErrorMessage();
}