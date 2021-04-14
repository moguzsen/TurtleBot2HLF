package org.example;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Transaction;
import static java.nio.charset.StandardCharsets.UTF_8;

@Default
public class TaskContract implements ContractInterface{
    public TaskContract(){

    }
    @Transaction()
    public boolean taskExists(Context ctx, int taskID) {
        byte[] buffer = ctx.getStub().getState(String.valueOf(taskID));
        return (buffer != null && buffer.length > 0);
    }
    @Transaction()
    public void createTask(Context ctx, int taskID, int robotID, Vector2 startPos, Vector2 goalPos, Status status) {
        boolean exists = taskExists(ctx,taskID);
        if (exists) {
            throw new RuntimeException("The task "+taskID+" already exists");
        }
        Task task = new Task();
        task.setTaskID(taskID);
        task.setRobotID(robotID);
        task.setStartPos(startPos);
        task.setGoalPos(goalPos);
        task.setStatus(status);
        ctx.getStub().putState(String.valueOf(taskID), task.toJSONString().getBytes(UTF_8));
    }

    @Transaction() //Bu metod overload edilsin mi?
    public void updateTask(Context ctx, int taskID, int robotID, Status status) {
        boolean exists = taskExists(ctx,taskID);
        if (!exists) {
            throw new RuntimeException("The task "+taskID+" does not exist");
        }
        Task task = new Task();
        task.setRobotID(robotID);
        task.setStatus(status);

        ctx.getStub().putState(String.valueOf(taskID), task.toJSONString().getBytes(UTF_8));
    }
    @Transaction()
    public Task showTaskInfo(Context ctx, int taskID){
        boolean exists = taskExists(ctx,taskID);
        if (!exists) {
            throw new RuntimeException("The task "+taskID+" does not exist");
        }

        Task task = Task.fromJSONString(new String(ctx.getStub().getState(String.valueOf(taskID)),UTF_8));
        return task;

    }
    @Transaction()
    public void assignTask(int robotID){

    }
    @Transaction()
    public void revokeTask(int robotID){

    }
    

}
