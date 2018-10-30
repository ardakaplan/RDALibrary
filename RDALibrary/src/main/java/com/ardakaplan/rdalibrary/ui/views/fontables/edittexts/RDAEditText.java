package com.ardakaplan.rdalibrary.ui.views.fontables.edittexts;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.ardakaplan.rdalibrary.ui.views.fontables.edittexts.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arda Kaplan on 30-Oct-18 - 10:51
 */
@SuppressWarnings("unused")
public class RDAEditText extends AppCompatEditText {

    private ArrayList<Validator> validators;

    public RDAEditText(Context context) {
        super(context);

        init();
    }

    public RDAEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public RDAEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    @SuppressWarnings("ConstantConditions")
    public String getPureString() {

        return getText().toString().trim();
    }

    private void init() {
        validators = new ArrayList<>();
    }


    public void addValidator(Validator validator) {
        this.validators.add(validator);
    }

    public ValidationResult validate() {

        ValidationResult validationResult = new ValidationResult();

        for (Validator validator : validators) {

            boolean isValid = validator.validate(getText().toString().trim());
            if (!isValid) {
                validationResult.addError(validator.getErrorMessage());
            }

        }

        return validationResult;
    }

    public class ValidationResult {

        private ArrayList<String> errors;

        private ValidationResult() {
            this.errors = new ArrayList<>();
        }

        public void addError(String error) {
            errors.add(error);
        }

        public boolean isValid() {
            return errors.size() == 0;
        }

        public List<String> getErrors() {
            return errors;
        }
    }
}
