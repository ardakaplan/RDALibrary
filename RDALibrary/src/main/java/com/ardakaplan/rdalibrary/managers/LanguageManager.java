package com.ardakaplan.rdalibrary.managers;

import android.content.res.Resources;

import com.ardakaplan.rdalibrary.base.RDASharedProperty;
import com.ardakaplan.rdalibrary.helpers.RDASharedHelpers;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan at 3/19/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
@SuppressWarnings("unused")
@Singleton
public class LanguageManager {

    private SelectedLanguageProperty selectedLanguageProperty;

    @Inject
    public LanguageManager(SelectedLanguageProperty selectedLanguageProperty) {
        this.selectedLanguageProperty = selectedLanguageProperty;
    }

    public Language getSelectedLanguage() {

        Language selectedLanguage = Language.DEFAULT;

        String searchingLanguage;

        if (selectedLanguageProperty.getValue() == null) {

            searchingLanguage = Resources.getSystem().getConfiguration().locale.getLanguage();

        } else {

            searchingLanguage = selectedLanguageProperty.getValue();
        }

        for (Language language : Language.values()) {

            if (language.getCode().equals(searchingLanguage)) {

                selectedLanguage = language;

                break;
            }
        }

        return selectedLanguage;
    }

    public void setSelectedLanguage(Language language) {

        selectedLanguageProperty.saveValue(language.getCode());
    }

    public enum Language {

        TURKISH("tr", "TÜRKÇE"),
        ENGLISH("en", "ENGLISH"),
        DEUTCSH("de", "DEUTSCH"),
        RUSSIAN("ru", "по-русски"),

        DEFAULT("-", "-");

        private String code;
        private String screenName;

        Language(String code, String screenName) {
            this.code = code;
            this.screenName = screenName;
        }

        public String getCode() {
            return code;
        }

        public String getScreenName() {
            return screenName;
        }

        public Locale getLocale() {

            if (this != DEFAULT) {

                return new Locale(code);

            } else {

                return Locale.getDefault();
            }
        }
    }

    /**
     * @return all languages apart from DEFAULT
     */
    public static List<Language> getAllDefinedLanguage() {

        List<Language> languages = Arrays.asList(Language.values());

        return languages.subList(0, languages.size() - 1);
    }

    public static class SelectedLanguageProperty extends RDASharedProperty<String> {

        @Inject
        SelectedLanguageProperty(RDASharedHelpers rdaSharedHelpers) {
            super(rdaSharedHelpers);
        }

        @Override
        public String getDefault() {
            return null;
        }


        @Override
        public String getValue() {
            return getStringValue();
        }

        @Override
        protected String getKey() {
            return "SelectedLanguageProperty";
        }
    }
}
