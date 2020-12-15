package com.rsh.wcf.pojo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Feature {
    public static final String PROP_TITLE = "title";
    public static final String PROP_DESCRIPTION = "description";
    public static final String PROP_CLIENT = "client";
    public static final String PROP_PRIORITY = "priority";
    public static final String PROP_TARGET_DATE = "targetDate";
    public static final String PROP_AREA = "area";

    private String title;
    private String description;
    private String client;
    private int priority;
    private String targetDate;
    private String area;

    public Feature( String title, String description, String client, int priority, String targetDate, String area ) {
        this.title = title;
        this.description = description;
        this.client = client;
        this.priority = priority;
        this.targetDate = targetDate;
        this.area = area;
    }

    public String getTitle() {
        return title;

    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getClient() {
        return client;
    }

    public void setClient( String client ) {
        this.client = client;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority( int priority ) {
        this.priority = priority;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate( String targetDate ) {
        this.targetDate = targetDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea( String area ) {
        this.area = area;
    }

}
