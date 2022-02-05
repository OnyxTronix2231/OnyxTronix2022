package frc.robot.trigger;

import com.revrobotics.Rev2mDistanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.loader.LoaderConstants.NORMAL_AMP;
import static frc.robot.trigger.BallTriggerConstants.DISTANCE_TO_STOP_IN_MM;

public class BallTrigger extends SubsystemBase {

    private final BallTriggerComponents triggerComponents;

    public BallTrigger(BallTriggerComponents triggerComponents) {
        this.triggerComponents = triggerComponents;
    }

    public void moveTriggerBySpeed(double speed) {
        triggerComponents.getTriggerMotor().set(speed);
    }


    public boolean isLoadedV2() {
        return triggerComponents.getDistanceSensor().getRange(Rev2mDistanceSensor.Unit.kMillimeters) > DISTANCE_TO_STOP_IN_MM;
    }

    @Override
    public void periodic() {
        System.out.println(triggerComponents.getDistanceSensor().getRange());
    }

    public boolean isStuck() {
        return triggerComponents.getTriggerMotor().getSupplyCurrent() > NORMAL_AMP;
    }

    public void stop() {
        moveTriggerBySpeed(0);
    }

}
