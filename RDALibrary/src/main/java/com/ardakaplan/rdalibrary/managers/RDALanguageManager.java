package com.ardakaplan.rdalibrary.managers;

import android.content.res.Resources;

import com.ardakaplan.rdalibrary.base.RDASharedProperty;
import com.ardakaplan.rdalibrary.data.models.language.RDAApplicationLanguageAdjuster;
import com.ardakaplan.rdalibrary.data.models.language.RDALanguage;
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
public class RDALanguageManager {

    private RDAApplicationLanguageAdjuster RDAApplicationLanguageAdjuster;
    private SelectedLanguageProperty selectedLanguageProperty;

    @Inject
    RDALanguageManager(RDAApplicationLanguageAdjuster RDAApplicationLanguageAdjuster, SelectedLanguageProperty selectedLanguageProperty) {
        this.RDAApplicationLanguageAdjuster = RDAApplicationLanguageAdjuster;
        this.selectedLanguageProperty = selectedLanguageProperty;
    }

    public RDALanguage getSelectedLanguage() {

        RDALanguage selectedRDALanguage = RDAApplicationLanguageAdjuster.getDefaultRDALanguage();

        String searchingLanguage;

        if (selectedLanguageProperty.getValue() == null) {

            searchingLanguage = Resources.getSystem().getConfiguration().locale.getLanguage();

        } else {

            searchingLanguage = selectedLanguageProperty.getValue();
        }

        for (RDALanguage RDALanguage : RDAApplicationLanguageAdjuster.getAllDefinedRDALanguages()) {

            if (RDALanguage.getCode().equals(searchingLanguage)) {

                selectedRDALanguage = RDALanguage;

                break;
            }
        }

        return selectedRDALanguage;
    }

    public void saveNewSelectedLanguage(RDALanguage RDALanguage) {

        selectedLanguageProperty.saveValue(RDALanguage.getCode());
    }

    public List<RDALanguage> getAllDefinedLanguage() {

        return RDAApplicationLanguageAdjuster.getAllDefinedRDALanguages();
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
