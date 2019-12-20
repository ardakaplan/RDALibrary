package com.ardakaplan.rdalibrary.base.objects;

import androidx.annotation.NonNull;

import com.ardakaplan.rdalibrary.helpers.RDAStringHelpers;

/**
 * Created by Arda Kaplan on 10.08.2018 - 14:40
 */
public abstract class RDAObject {

    @NonNull
    @Override
    public String toString() {

        return RDAStringHelpers.getAsJsonWithFormat(this);
    }
}
