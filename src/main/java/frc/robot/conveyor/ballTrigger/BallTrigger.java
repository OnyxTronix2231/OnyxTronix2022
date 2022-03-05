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

//    public double getRed() {
//        return components.getColorSensor().getColor().red;
//    }
//
//    public double getBlue() {
//        return components.getColorSensor().getColor().blue;
//    }
//
//    public boolean isRed() {
//        return components.getColorSensor().getColor().red >= ballTriggerShuffleboard.getIsRedEntry();
//    }
//
//    public boolean isBlue() {
//        return components.getColorSensor().getColor().blue >= ballTriggerShuffleboard.getIsBlueEntry();
//    }

//    public boolean isBlueAlliance() {
//        return DriverStation.getAlliance() == DriverStation.Alliance.Blue;
//    }

//    public boolean isBlueAndNotRed(){
//        return components.getColorSensor().getColor().blue > components.getColorSensor().getColor().red;
//    }
//    public boolean isBallIsTheSameColorAsTeam(){
//        return isBlueAlliance() == isBlueAndNotRed();
//    }
}
