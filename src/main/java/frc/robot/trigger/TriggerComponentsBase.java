package frc.robot.trigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.trigger.Trigger;
import frc.robot.trigger.TriggerComponents;

import static frc.robot.trigger.TriggerConstants.TRIGGER_MOTOR_ID;


public class TriggerComponentsBase implements TriggerComponents {

    private WPI_TalonFX triggerMotor;

    public TriggerComponentsBase() {
        triggerMotor = new WPI_TalonFX(TRIGGER_MOTOR_ID);
        triggerMotor.configFactoryDefault();

    }

    @Override
    public WPI_TalonFX getTriggerMotor() {
        return triggerMotor;
    }

}
