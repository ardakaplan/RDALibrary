package com.ardakaplan.rdalibrary.base;

import com.ardakaplan.rdalibrary.helpers.RDASharedHelpers;

/**
 * Created by Arda Kaplan on 05-Feb-19 - 15:47
 * <p>
 * binds data with its class long name "CanonicalName" and save into shared
 * <p>
 * W can be Integer,Boolean,Long,String
 */
public abstract class RDASharedProperty<W> {

    private RDASharedHelpers rdaSharedHelpers;

    protected String key;

    public RDASharedProperty(RDASharedHelpers rdaSharedHelpers) {
        this.rdaSharedHelpers = rdaSharedHelpers;

        key = getClass().getCanonicalName();
    }

    public void saveValue(W w) {

        if (w instanceof Integer) {

            rdaSharedHelpers.putInt(key, (Integer) w);

        } else if (w instanceof String) {

            rdaSharedHelpers.putString(key, (String) w);

        } else if (w instanceof Boolean) {

            rdaSharedHelpers.putBoolean(key, (Boolean) w);

        } else if (w instanceof Long) {

            rdaSharedHelpers.putLong(key, (Long) w);
        }
    }

    protected Integer getIntegerValue() {

        return rdaSharedHelpers.getInt(key, (Integer) getDefault());
    }

    protected String getStringValue() {

        return rdaSharedHelpers.getString(key, (String) getDefault());
    }

    protected Boolean getBooleanValue() {

        return rdaSharedHelpers.getBoolean(key, (Boolean) getDefault());
    }

    protected Long getLongValue() {

        return rdaSharedHelpers.getLong(key, (Long) getDefault());
    }

    public void delete() {

        rdaSharedHelpers.delete(key);
    }

    public abstract W getDefault();

    public abstract W getValue();
}
