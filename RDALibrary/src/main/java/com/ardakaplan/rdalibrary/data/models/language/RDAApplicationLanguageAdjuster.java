package com.ardakaplan.rdalibrary.data.models.language;

import com.ardakaplan.rdalibrary.base.objects.RDAObject;

import java.util.List;

/**
 * Created by Arda Kaplan at 10-Aug-20 - 10:08
 * <p>
 * ardakaplan101@gmail.com
 */
public final class RDAApplicationLanguageAdjuster extends RDAObject {

    private RDALanguage defaultRDALanguage;
    private List<RDALanguage> allDefinedRDALanguages;

    public RDAApplicationLanguageAdjuster(RDALanguage defaultRDALanguage, List<RDALanguage> allDefinedRDALanguages) {
        this.defaultRDALanguage = defaultRDALanguage;
        this.allDefinedRDALanguages = allDefinedRDALanguages;
    }

    public RDALanguage getDefaultRDALanguage() {
        return defaultRDALanguage;
    }

    public List<RDALanguage> getAllDefinedRDALanguages() {
        return allDefinedRDALanguages;
    }
}
