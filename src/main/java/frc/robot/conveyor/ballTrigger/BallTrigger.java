package frc.robot.conveyor.ballTrigger;

import com.revrobotics.Rev2mDistanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.IN_PLACE_DISTANCE_MM;
import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.IDENTIFIED_DISTANCE_MM;

public class BallTrigger extends SubsystemBase {

    private final BallTriggerComponents components;
    private final BallTriggerShuffleboard ballTriggerShuffleboard;


    public BallTrigger(BallTriggerComponents components) {
        this.components = components;
        this.ballTriggerShuffleboard = new BallTriggerShuffleboard(this);
    }

    public void moveTriggerBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public boolean isBallInPlace() {
        return getDistance() >= ballTriggerShuffleboard.getBallInPlaceValue() && getDistance() != -1;
    }

    public boolean isBallIdentified() {

        return getDistance() <= ballTriggerShuffleboard.getIdentifiedBallValue() && getDistance() != -1;
    }

    public void stop() {
        moveTriggerBySpeed(0);
    }

    public double getDistance() {
        return components.getDistanceSensorUp().
                getRange(Rev2mDistanceSensor.Unit.kMillimeters);
    }
}