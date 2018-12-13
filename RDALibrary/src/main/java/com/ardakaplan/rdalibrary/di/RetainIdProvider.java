package com.ardakaplan.rdalibrary.di;

/**
 * Created by Arda Kaplan on 12-Dec-18 - 15:22
 */
public interface RetainIdProvider {

    String provideUniqueId();
    boolean retain();
}
