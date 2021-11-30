package com.ardakaplan.rdalibrary.helpers;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public final class RDACollectionsHelpers {

    private RDACollectionsHelpers() {

    }

    public static boolean isMapEmpty(Map<?, ?> map) {

        return map == null || map.isEmpty();
    }

    public static boolean isListNull(List<?> list) {

        return list == null;
    }

    public static boolean isListEmpty(List<?> list) {

        return isListNull(list) || list.size() == 0;
    }
}
