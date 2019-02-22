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

    public RDASharedProperty(RDASharedHelpers rdaSharedHelpers) {
        this.rdaSharedHelpers = rdaSharedHelpers;
    }

    public void saveValue(W w) {

        if (w instanceof Integer) {

            rdaSharedHelpers.putInt(getKey(), (Integer) w);

        } else if (w instanceof String) {

            rdaSharedHelpers.putString(getKey(), (String) w);

        } else if (w instanceof Boolean) {

            rdaSharedHelpers.putBoolean(getKey(), (Boolean) w);

        } else if (w instanceof Long) {

            rdaSharedHelpers.putLong(getKey(), (Long) w);
        }
    }

    protected Integer getIntegerValue() {

        return rdaSharedHelpers.getInt(getKey(), (Integer) getDefault());
    }

    protected String getStringValue() {

        return rdaSharedHelpers.getString(getKey(), (String) getDefault());
    }

    protected Boolean getBooleanValue() {

        return rdaSharedHelpers.getBoolean(getKey(), (Boolean) getDefault());
    }

    protected Long getLongValue() {

        return rdaSharedHelpers.getLong(getKey(), (Long) getDefault());
    }

    public void delete() {

        rdaSharedHelpers.delete(getKey());
    }

    public abstract W getDefault();

    public abstract W getValue();

    public abstract String getKey();
}
