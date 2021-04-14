/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import com.owlike.genson.Genson;

@DataType()
public class Robot {

    private final static Genson genson = new Genson();

    @Property()
    private float batteryLife;
    @Property()
    private String robotAddress;
    @Property()
    private int robotID;
    @Property()
    private int batteryThreshold;
    @Property()
    private boolean isCharging;
    @Property()
    private boolean hasWeight;
    @Property()
    private boolean ontheTask;
    @Property()
    private Task task;
    @Property()
    private Vector2 position;
    @Property
    private double orientation;
    @Property
    private double[] distanceToRobots;
    @Property
    private boolean isLeader;
    @Property
    private boolean isWorker;

    public Robot(){
    }

    public float getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(float batteryLife) {
        this.batteryLife = batteryLife;
    }

    public String getRobotAddress() {
        return robotAddress;
    }

    public void setRobotAddress(String robotAddress) {
        this.robotAddress = robotAddress;
    }

    public int getRobotID() {
        return robotID;
    }

    public void setRobotID(int robotID) {
        this.robotID = robotID;
    }

    public int getBatteryThreshold() {
        return batteryThreshold;
    }

    public void setBatteryThreshold(int batteryThreshold) {
        this.batteryThreshold = batteryThreshold;
    }

    public boolean isCharging() {
        return isCharging;
    }

    public void setCharging(boolean isCharging) {
        this.isCharging = isCharging;
    }

    public boolean isHasWeight() {
        return hasWeight;
    }

    public void setHasWeight(boolean hasWeight) {
        this.hasWeight = hasWeight;
    }

    public boolean isOntheTask() {
        return ontheTask;
    }

    public void setOntheTask(boolean ontheTask) {
        this.ontheTask = ontheTask;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public double getOrientation() {
        return orientation;
    }

    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }

    public double[] getDistanceToRobots() {
        return distanceToRobots;
    }

    public void setDistanceToRobots(double[] distanceToRobots) {
        this.distanceToRobots = distanceToRobots;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean isLeader) {
        this.isLeader = isLeader;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean isWorker) {
        this.isWorker = isWorker;
    }

    public String toJSONString() {
        return genson.serialize(this).toString();
    }

    public static Robot fromJSONString(String json) {
        Robot robot = genson.deserialize(json, Robot.class);
        return robot;
    }
}
