package org.example;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import com.owlike.genson.Genson;

@DataType()
public class Task {
    private final static Genson genson = new Genson();
    @Property()
    private int taskID;
    @Property()
    private int robotID;
    @Property()
    private Vector2 startPos;
    @Property()
    private Vector2 goalPos;
    @Property()
    private Status status;
    public Task(){
        
    }
    public int getTaskID() {
        return taskID;
    }
    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
    public int getRobotID() {
        return robotID;
    }
    public void setRobotID(int robotID) {
        this.robotID = robotID;
    }
    public Vector2 getStartPos() {
        return startPos;
    }
    public void setStartPos(Vector2 startPos) {
        this.startPos = startPos;
    }
    public Vector2 getGoalPos() {
        return goalPos;
    }
    public void setGoalPos(Vector2 goalPos) {
        this.goalPos = goalPos;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public String toJSONString() {
        return genson.serialize(this).toString();
    }
    public static Task fromJSONString(String json) {
        Task task = genson.deserialize(json, Task.class);
        return task;
    }

}
