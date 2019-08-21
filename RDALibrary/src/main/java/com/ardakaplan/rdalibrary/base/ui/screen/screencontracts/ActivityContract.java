package com.ardakaplan.rdalibrary.base.ui.screen.screencontracts;

import android.content.Context;

import java.util.Locale;

/**
 * Created by Arda Kaplan at 4/5/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public interface ActivityContract extends ScreenContract {

    Context changeLanguage(Context context, Locale locale);
}
