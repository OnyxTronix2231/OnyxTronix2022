package frc.robot.conveyor.ballTrigger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BallTrigger extends SubsystemBase {

    private final BallTriggerComponents components;
    private final BallTriggerShuffleboard ballTriggerShuffleboard;
    private double currentAnalogVoltage;

    public BallTrigger(BallTriggerComponents components) {
        this.components = components;
        this.ballTriggerShuffleboard = new BallTriggerShuffleboard(this);
        ballTriggerShuffleboard.init();
    }

    public void moveTriggerBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public boolean isBallIdentified() {
        return components.getAnalogSensor().getVoltage() >= ballTriggerShuffleboard.getIdentifiedBallValueEntry();
    }

    public double getAnalogSensorVoltage(){
        return components.getAnalogSensor().getVoltage();
    }

    public void stop() {
        moveTriggerBySpeed(0);
    }
}
