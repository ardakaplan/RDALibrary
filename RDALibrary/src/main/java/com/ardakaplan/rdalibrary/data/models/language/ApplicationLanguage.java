package com.ardakaplan.rdalibrary.data.models.language;

import com.ardakaplan.rdalibrary.base.objects.RDAObject;

import java.util.List;

/**
 * Created by Arda Kaplan at 10-Aug-20 - 10:08
 * <p>
 * ardakaplan101@gmail.com
 */
public final class ApplicationLanguage extends RDAObject {

    private Language defaultLanguage;
    private List<Language> allDefinedLanguages;

    public ApplicationLanguage(Language defaultLanguage, List<Language> allDefinedLanguages) {
        this.defaultLanguage = defaultLanguage;
        this.allDefinedLanguages = allDefinedLanguages;
    }

    public Language getDefaultLanguage() {
        return defaultLanguage;
    }

    public List<Language> getAllDefinedLanguages() {
        return allDefinedLanguages;
    }
}
