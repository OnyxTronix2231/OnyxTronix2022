package frc.robot.Conveyor;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Conveyor.ConveyorComponents;
import frc.robot.Conveyor.ConveyorConstants.*;

import static frc.robot.Conveyor.ConveyorConstants.ConveyorConstantsBase.*;


public class ConveyorComponentsBase implements ConveyorComponents {
        private WPI_TalonFX firstMotor;
        private WPI_TalonFX secondMotor;

    public ConveyorComponentsBase(WPI_TalonFX firstMotor, WPI_TalonFX secondMotor) {
        firstMotor = new WPI_TalonFX(FIRST_MOTOR_ID);
        secondMotor = new WPI_TalonFX(SECOND_MOTOR_ID);


    }

    @Override
    public WPI_TalonFX getFirstMotor() {
        return firstMotor;
    }

    @Override
    public WPI_TalonFX getSecondMotor() {
        return secondMotor;
    }
}
