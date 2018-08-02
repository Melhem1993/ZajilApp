package com.bridgefy.samples.twitter.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "USERNAME")
    private String USERNAME;

    @ColumnInfo(name = "UUID")
    private String UUID;

    @ColumnInfo(name = "DEVICE")
    private String DEVICE;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getDEVICE() {
        return DEVICE;
    }

    public void setDEVICE(String DEVICE) {
        this.DEVICE = DEVICE;
    }

}