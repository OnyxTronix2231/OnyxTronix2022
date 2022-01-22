package frc.robot.conveyor.Trigger;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import static frc.robot.conveyor.Loader.LoaderConstants.TRIGGER_MOTOR_ID;

public class TriggerComponentsBase implements TriggerComponents{
    private WPI_TalonFX triggerMotor;

    public TriggerComponentsBase() {
        triggerMotor = new WPI_TalonFX(TRIGGER_MOTOR_ID);
        triggerMotor.configFactoryDefault();
    }
    @Override
    public WPI_TalonFX getLoaderMotor() {
        return null;
    }
}
