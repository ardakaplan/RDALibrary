package com.ardakaplan.rdalibrary.data.models.language;

import com.ardakaplan.rdalibrary.base.objects.RDAObject;

import java.util.Locale;

/**
 * Created by Arda Kaplan at 10-Aug-20 - 09:06
 * <p>
 * ardakaplan101@gmail.com
 */
public class Language extends RDAObject {

    private String code;
    private String screenName;

    public Language(String code, String screenName) {
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

        return new Locale(code);
    }
}
