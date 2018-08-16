package com.ardakaplan.rdalibrary.objects;

import com.ardakaplan.rdalibrary.helpers.RDAStringHelpers;

import java.io.Serializable;

/**
 * Created by Arda Kaplan on 10.08.2018 - 14:40
 */
public abstract class RDAObject implements Serializable {

    @Override
    public String toString() {

        return RDAStringHelpers.getAsJson(this);
    }
}
