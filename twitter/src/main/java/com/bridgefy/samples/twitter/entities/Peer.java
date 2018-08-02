package com.bridgefy.samples.twitter.entities;

import com.google.gson.Gson;

/**
 * @author dekaru on 5/9/17.
 */

public class Peer {

    private String  device_name;
    private String  uuid;
    private String uniqueid;
    private boolean isNearby;
    private DeviceType deviceType;
    private boolean isOnline;

    public enum DeviceType {
        UNDEFINED,
        ANDROID,
        IPHONE
    }


    public Peer(String uuid, String device_name, String uniqueid) {
        this.uuid = uuid;
        this.device_name = device_name;
        this.uniqueid = uniqueid;
    }


    public String getDeviceName() {
        return device_name;
    }

    public String getUuid() {
        return uuid;
    }
    public String getuniqueid() {
        return uniqueid;
    }

    public void setuniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }


    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public boolean isNearby() {
        return isNearby;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public void setNearby(boolean nearby) {
        isNearby = nearby;
    }


    public static Peer create(String json) {
        return new Gson().fromJson(json, Peer.class);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
