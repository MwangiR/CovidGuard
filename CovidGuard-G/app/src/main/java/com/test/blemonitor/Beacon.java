package com.test.blemonitor;


public class Beacon {
    private String entryTimestamp, exitTimestamp, venueId;

    public void setEntryTimestamp(String entryTimestamp) {
        this.entryTimestamp = entryTimestamp;

    }

    public String getEntryTimestamp() {
        return entryTimestamp;
    }

    public void setExitTimestamp(String exitTimestamp) {
        this.exitTimestamp = exitTimestamp;
    }

    public String getExitTimestamp() {
        return exitTimestamp;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getVenueId() {
        return venueId;
    }
}
