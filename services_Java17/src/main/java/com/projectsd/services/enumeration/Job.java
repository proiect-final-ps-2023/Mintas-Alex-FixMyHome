package com.projectsd.services.enumeration;

public enum Job {
    TileSetter("TileSetter"),
    Painter("Painter"),
    Electrician("Electrician"),
    Plumber("Plumber"),
    Locksmith("Locksmith");

    private final String job;

    Job(String job) {
        this.job = job;
    }

    public String getJob() {
        return this.job;
    }

}