package frc.robot.conveyor.ballTrigger;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.Rev2mDistanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.THRESHOLD_BLUENESS;

public class BallTrigger extends SubsystemBase {

    private final BallTriggerComponents components;
    private final BallTriggerShuffleboard ballTriggerShuffleboard;
    private double currentDistance;

    public BallTrigger(BallTriggerComponents components) {
        this.components = components;
        this.ballTriggerShuffleboard = new BallTriggerShuffleboard(this);
        ballTriggerShuffleboard.init();
    }

    @Override
    public void periodic() {
        currentDistance = getDistance();
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

    public double getColorDistance(){
        return components.getColorSensor().getProximity();
    }

    public boolean isBlue(){
        return components.getColorSensor().getColor().blue > THRESHOLD_BLUENESS;
    }

    public double getBlue(){
        return components.getColorSensor().getColor().blue;
    }
}
