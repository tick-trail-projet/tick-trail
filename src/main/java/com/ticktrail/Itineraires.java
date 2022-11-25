package com.ticktrail;

public class Itineraires {
    private String start;
    private String end;

    public Itineraires(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return this.start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return this.end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Itineraires start(String start) {
        setStart(start);
        return this;
    }

    public Itineraires end(String end) {
        setEnd(end);
        return this;
    }
}
