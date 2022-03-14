package frc.robot.conveyor.ballTrigger;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BallTrigger extends SubsystemBase {

    private final BallTriggerComponents components;
    private final BallTriggerShuffleboard ballTriggerShuffleboard;
    private double currentAnalogVoltage;

    public BallTrigger(BallTriggerComponents components) {
        this.components = components;
        this.ballTriggerShuffleboard = new BallTriggerShuffleboard(this);
        //ballTriggerShuffleboard.init();
    }

    @Override
    public void periodic() {
        currentAnalogVoltage = components.getAnalogSensor().getVoltage();
    }

    public void moveTriggerBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public boolean isBallIdentified() {
        return currentAnalogVoltage >= ballTriggerShuffleboard.getIdentifiedBallValueEntry();
    }

    public double getAnalogSensorVoltage(){
        return currentAnalogVoltage;
    }

    public void stop() {
        moveTriggerBySpeed(0);
    }
}
