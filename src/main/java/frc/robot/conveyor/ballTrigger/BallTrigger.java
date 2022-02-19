package frc.robot.conveyor.ballTrigger;

import com.revrobotics.Rev2mDistanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.DISTANCE_IN_PLACE_MM;
import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.NORMAL_DISTANCE_MM;

public class BallTrigger extends SubsystemBase {

    private final BallTriggerComponents components;

    public BallTrigger(BallTriggerComponents components) {
        this.components = components;
    }

    public void moveTriggerBySpeed(double speed) {
        components.getMotor().set(speed);
    }

    public boolean isBallInPlace() {
        return components.getDistanceSensorUp().
                getRange(Rev2mDistanceSensor.Unit.kMillimeters) <= DISTANCE_IN_PLACE_MM;
    }

    public boolean isBallIdentified() {
        return components.getDistanceSensorUp().
                getRange(Rev2mDistanceSensor.Unit.kMillimeters) <= NORMAL_DISTANCE_MM;
    }

    public void stop() {
        moveTriggerBySpeed(0);
    }
}
