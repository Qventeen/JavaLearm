package com.jr.level.level39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if(versionHistoryMap.containsKey(rollbackVersion)){
            currentVersion = rollbackVersion;
            versionHistoryMap.entrySet().removeIf(
                    entry -> entry.getKey().compareTo(rollbackVersion) > 0
            );
            return true;
        }

        return false;
    }
}
