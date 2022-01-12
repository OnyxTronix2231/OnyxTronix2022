package frc.robot.Conveyor;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import static frc.robot.Conveyor.Constants.FIRST_MOTOR_ID;
import static frc.robot.Conveyor.Constants.SECOND_MOTOR_ID;


public class ConveyorComponentsBase implements ConveyorComponents {
    private WPI_TalonFX triggerMotor;
    private WPI_TalonFX secondMotor;


    public ConveyorComponentsBase(WPI_TalonFX firstMotor, WPI_TalonFX secondMotor) {
        triggerMotor = new WPI_TalonFX(FIRST_MOTOR_ID);
        triggerMotor.configFactoryDefault();
        secondMotor = new WPI_TalonFX(SECOND_MOTOR_ID);
        secondMotor.configFactoryDefault();
    }


    @Override
    public WPI_TalonFX getTriggerMotor() {
        return triggerMotor;
    }

    @Override
    public WPI_TalonFX getFloorMotor() {
        return secondMotor;
    }
}
