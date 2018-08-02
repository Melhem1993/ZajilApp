package com.bridgefy.samples.twitter.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Chat")
public class Chat {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "MSG")
    private String MSG;

    @ColumnInfo(name = "FROMUUID")
    private String FROMUUID;

    @ColumnInfo(name = "TOUUID")
    private String TOUUID;

    @ColumnInfo(name = "READ")
    private boolean READ;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getMSG() {
        return MSG;
    }

    public void setMSG(String MSG) {
        this.MSG = MSG;
    }

    public String getFROMUUID() {
        return FROMUUID;
    }

    public void setFROMUUID(String FROMUUID) {
        this.FROMUUID = FROMUUID;
    }

    public String getTOUUID() {
        return TOUUID;
    }

    public void setTOUUID(String TOUUID) {
        this.TOUUID = TOUUID;
    }

    public boolean getREAD() {
        return READ;
    }

    public void setREAD(boolean READ) {
        this.READ = READ;
    }

}