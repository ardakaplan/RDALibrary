package com.ardakaplan.rdalibrary.ui.views.fontables.edittexts.validators;

public class TextLengthValidator implements Validator {


    private String errorText;
    private Condition[] conditions;

    public TextLengthValidator(Condition... conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean validate(String text) {

        if (conditions != null && conditions.length > 0) {

            for (Condition condition : conditions) {

                if (!condition.process(text.trim())) {

                    errorText = condition.getErrorText();

                    return false;
                }
            }
        } else {

            return false;
        }

        return true;
    }

    @Override
    public String getErrorMessage() {
        return errorText;
    }

    public static class Condition {

        private int value;
        private Operator operator;
        private String errorText;

        public Condition(int value, Operator operator, String errorText) {
            this.value = value;
            this.operator = operator;
            this.errorText = errorText;
        }

        private String getErrorText() {
            return errorText;
        }

        private boolean process(String text) {

            switch (operator) {

                case EQUAL:

                    return text != null && text.length() == value;

                case LESS_THEN:

                    return text != null && text.length() < value;

                case LESS_THEN_OR_EQUAL:

                    return text != null && text.length() <= value;

                case GREATER_THEN:

                    return text != null && text.length() > value;

                case GREATER_THEN_OR_EQUAL:

                    return text != null && text.length() >= value;
            }

            return false;
        }
    }

    public enum Operator {
        LESS_THEN,
        LESS_THEN_OR_EQUAL,
        GREATER_THEN,
        GREATER_THEN_OR_EQUAL,
        EQUAL
    }
}