package com.ardakaplan.rdalibrary.managers;

import android.content.res.Resources;

import com.ardakaplan.rdalibrary.base.RDASharedProperty;
import com.ardakaplan.rdalibrary.data.models.language.ApplicationLanguage;
import com.ardakaplan.rdalibrary.data.models.language.Language;
import com.ardakaplan.rdalibrary.helpers.RDASharedHelpers;

import java.util.List;

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

    private ApplicationLanguage applicationLanguage;
    private SelectedLanguageProperty selectedLanguageProperty;

    @Inject
    LanguageManager(ApplicationLanguage applicationLanguage, SelectedLanguageProperty selectedLanguageProperty) {
        this.applicationLanguage = applicationLanguage;
        this.selectedLanguageProperty = selectedLanguageProperty;
    }

    public Language getSelectedLanguage() {

        Language selectedLanguage = applicationLanguage.getDefaultLanguage();

        String searchingLanguage;

        if (selectedLanguageProperty.getValue() == null) {

            searchingLanguage = Resources.getSystem().getConfiguration().locale.getLanguage();

        } else {

            searchingLanguage = selectedLanguageProperty.getValue();
        }

        for (Language language : applicationLanguage.getAllDefinedLanguages()) {

            if (language.getCode().equals(searchingLanguage)) {

                selectedLanguage = language;

                break;
            }
        }

        return selectedLanguage;
    }

    public void saveNewSelectedLanguage(Language language) {

        selectedLanguageProperty.saveValue(language.getCode());
    }

    public List<Language> getAllDefinedLanguage() {

        return applicationLanguage.getAllDefinedLanguages();
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
