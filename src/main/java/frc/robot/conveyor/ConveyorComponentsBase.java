package frc.robot.conveyor;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import static frc.robot.conveyor.ConveyorConstants.TRIGGER_MOTOR_ID;
import static frc.robot.conveyor.ConveyorConstants.LOADER_MOTOR_ID;


public class ConveyorComponentsBase implements ConveyorComponents {

    private WPI_TalonFX triggerMotor;
    private WPI_TalonFX loaderMotor;

    public ConveyorComponentsBase() {
        triggerMotor = new WPI_TalonFX(TRIGGER_MOTOR_ID);
        triggerMotor.configFactoryDefault();
        loaderMotor = new WPI_TalonFX(LOADER_MOTOR_ID);
        loaderMotor.configFactoryDefault();
    }

    @Override
    public WPI_TalonFX getTriggerMotor() {
        return triggerMotor;
    }

    @Override
    public WPI_TalonFX getLoaderMotor() {
        return loaderMotor;
    }
}
