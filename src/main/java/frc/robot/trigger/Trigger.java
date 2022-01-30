package frc.robot.trigger;

import com.revrobotics.Rev2mDistanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.loader.LoaderConstants.NORMAL_AMP;
import static frc.robot.trigger.TriggerConstants.DISTANCE_SENSOR_PORT;
import static frc.robot.trigger.TriggerConstants.DISTANCE_TO_STOP_IN_MM;

public class Trigger extends SubsystemBase {

    private final TriggerComponents triggerComponents;

    public Trigger(TriggerComponents triggerComponents) {
        this.triggerComponents = triggerComponents;
    }

    public void moveTriggerBySpeed(double speed) {
        triggerComponents.getTriggerMotor().set(speed);
    }

    public boolean isLoaded() {
       return triggerComponents.getUltraSonic().getRangeMM() > DISTANCE_TO_STOP_IN_MM;
    }

    public boolean isLoadedV2(){
        return triggerComponents.getDistanceSensor().getRange(Rev2mDistanceSensor.Unit.kMillimeters)> DISTANCE_TO_STOP_IN_MM;
    }
    public void stop(){
        moveTriggerBySpeed(0);
    }
    public boolean isStuck() {
        return triggerComponents.getTriggerMotor().getSupplyCurrent() > NORMAL_AMP;
        //in one side is geting amper and other is checking amper he he ha ha yeahhhhhhh
    }

}
