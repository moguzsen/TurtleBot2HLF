/*
 * SPDX-License-Identifier: Apache-2.0
 */
package org.example;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.contract.annotation.Contact;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.License;
import static java.nio.charset.StandardCharsets.UTF_8;

@Contract(name = "RobotContract",
    info = @Info(title = "Robot contract",
                description = "My Smart Contract",
                version = "0.0.1",
                license =
                        @License(name = "Apache-2.0",
                                url = ""),
                                contact =  @Contact(email = "Robot@example.com",
                                                name = "Robot",
                                                url = "http://Robot.me")))
@Default
public class RobotContract implements ContractInterface {
    public  RobotContract() {

    }
    @Transaction()
    public boolean robotExists(Context ctx, String robotId) {
        byte[] buffer = ctx.getStub().getState(robotId);
        return (buffer != null && buffer.length > 0);
    }

    @Transaction()
    public void createRobot(Context ctx, String robotId, String value) {
        boolean exists = robotExists(ctx,robotId);
        if (exists) {
            throw new RuntimeException("The robot "+robotId+" already exists");
        }
        Robot robot = new Robot();
        robot.setRobotAddress(value);
        ctx.getStub().putState(robotId, robot.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public Robot readRobot(Context ctx, String robotId) {
        boolean exists = robotExists(ctx,robotId);
        if (!exists) {
            throw new RuntimeException("The robot "+robotId+" does not exist");
        }

        Robot newAsset = Robot.fromJSONString(new String(ctx.getStub().getState(robotId),UTF_8));
        return newAsset;
    }

    @Transaction()
    public void updateRobot(Context ctx, String robotId, String newValue) {
        boolean exists = robotExists(ctx,robotId);
        if (!exists) {
            throw new RuntimeException("The robot "+robotId+" does not exist");
        }
        Robot robot = new Robot();
        robot.setRobotAddress(newValue);

        ctx.getStub().putState(robotId, robot.toJSONString().getBytes(UTF_8));
    }


    @Transaction()
    public boolean isRobotDown(int robotID){
        //Checks if a robot is reachable and connected to the blockchain network.
        return true;
    }
    @Transaction()
    public void dispatchToCharging(int robotID){
       //If a robot’s battery life is below a threshold value, this method is called to dispatch the robot to the nearest available charging station. 
    }
    @Transaction()
    public boolean loadWeight(){
        return true;

    }
    @Transaction()
    public boolean unloadWeight(){
        return true;
    }
    @Transaction()
    public void checkNearbyRobots(){

    }
    @Transaction()
    public void gotoGoal(){

    }
    @Transaction()
    public void gotoTask(){

    }
    @Transaction()
    public void optimumtaskAllocation(){

    }
    @Transaction()
    public void selectaLeader(){

    }
    @Transaction()
    public void pathPlanning(){

    }

}
