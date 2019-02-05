package com.ardakaplan.rdalibrary;

import com.ardakaplan.rdalibrary.helpers.RDASharedHelpers;

/**
 * Created by Arda Kaplan on 05-Feb-19 - 15:47
 * <p>
 * binds data with its class long name "CanonicalName" and save into shared
 * <p>
 * W can be Integer,Boolean,Long,String
 */
public abstract class RDASharedProperty<W extends Object> {

    private W w;

    private RDASharedHelpers rdaSharedHelpers;

    public RDASharedProperty(RDASharedHelpers rdaSharedHelpers) {
        this.rdaSharedHelpers = rdaSharedHelpers;
    }

    public void saveValue(W w) {

        this.w = w;

        if (w instanceof Integer) {

            rdaSharedHelpers.putInt(getClass().getCanonicalName(), (Integer) w);

        } else if (w instanceof String) {

            rdaSharedHelpers.putString(getClass().getCanonicalName(), (String) w);

        } else if (w instanceof Boolean) {

            rdaSharedHelpers.putBoolean(getClass().getCanonicalName(), (Boolean) w);

        } else if (w instanceof Long) {

            rdaSharedHelpers.putLong(getClass().getCanonicalName(), (Long) w);
        }
    }

    @SuppressWarnings("unchecked")
    public Object getValue() {

        if (w instanceof Integer) {

            return rdaSharedHelpers.getInt(getClass().getCanonicalName(), (Integer) getDefault());

        } else if (w instanceof String) {

            return rdaSharedHelpers.getString(getClass().getCanonicalName(), (String) getDefault());

        } else if (w instanceof Boolean) {

            return rdaSharedHelpers.getBoolean(getClass().getCanonicalName(), (Boolean) getDefault());

        } else if (w instanceof Long) {

            return rdaSharedHelpers.getBoolean(getClass().getCanonicalName(), (Boolean) getDefault());

        } else {
            //impossible
            return null;
        }
    }

    public abstract W getDefault();
}
