package frc.robot.conveyor.ballTrigger;

import com.revrobotics.Rev2mDistanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.*;

public class BallTrigger extends SubsystemBase {

    private final BallTriggerComponents components;
    private final BallTriggerShuffleboard ballTriggerShuffleboard;
    private double currentDistance;
    private double currentColorDistance;
    private double currentAnalogDistance;

    public BallTrigger(BallTriggerComponents components) {
        this.components = components;
        this.ballTriggerShuffleboard = new BallTriggerShuffleboard(this);
        ballTriggerShuffleboard.init();
    }

    @Override
    public void periodic() {
        currentDistance = getDistance();
        currentColorDistance = getColorDistance();
        currentAnalogDistance = getAnalogDistance();
    }

    public void moveTriggerBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public boolean isBallInPlace() {
        return currentDistance >= ballTriggerShuffleboard.getBallInPlaceValueEntry() && currentDistance != -1;
    }

    public boolean isBallIdentified() {
        return currentDistance <= ballTriggerShuffleboard.getIdentifiedBallValueEntry() && currentDistance != -1;
    }

    public void stop() {
        moveTriggerBySpeed(0);
    }

    public double getDistance() {
        return components.getDistanceSensorUp().getRange(Rev2mDistanceSensor.Unit.kMillimeters);
    }

    public double getRed(){
        return components.getColorSensor().getColor().red;
    }

    public double getBlue(){
        return components.getColorSensor().getColor().blue;
    }

    public boolean isRed(){
        return components.getColorSensor().getColor().red >= ballTriggerShuffleboard.getIsRedEntry();
    }

    public boolean isBlue(){
        return components.getColorSensor().getColor().blue >= ballTriggerShuffleboard.getIsBlueEntry();
    }

    public int getColorDistance(){
        return components.getColorSensor().getProximity();
    }

    public boolean isBallInPlaceV2(){
        return currentColorDistance >=  ballTriggerShuffleboard.getBallInPlaceValueEntryV2();
    }

    public double getAnalogDistance(){
        return components.getAnalogSensor().getDistance();
    }

    public boolean isBallIdentifiedV2(){
        return currentAnalogDistance <= ballTriggerShuffleboard.getIdentifiedBallValueEntryV2();
    }
}
