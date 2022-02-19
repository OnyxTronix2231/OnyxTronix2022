package frc.robot.conveyor.ballTrigger;

import com.revrobotics.Rev2mDistanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.*;

public class BallTrigger extends SubsystemBase {

    private final BallTriggerComponents triggerComponents;

    public BallTrigger(BallTriggerComponents triggerComponents) {
        this.triggerComponents = triggerComponents;
    }

    public void moveTriggerBySpeed(double speed) {
        triggerComponents.getMotor().set(speed);
    }

    public boolean isLoadedRev() {
        return triggerComponents.getDistanceSensorUp().
                getRange(Rev2mDistanceSensor.Unit.kMillimeters) <= DISTANCE_TO_STOP_IN_MM;
    }

    public boolean isHalfLoadedRev() {
        return triggerComponents.getDistanceSensorUp().
                getRange(Rev2mDistanceSensor.Unit.kMillimeters) <= TRIGGER_HALF_LOADED;
    }

    public void stop() {
        moveTriggerBySpeed(0);
    }
}
