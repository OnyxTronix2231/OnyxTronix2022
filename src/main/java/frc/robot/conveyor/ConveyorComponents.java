package frc.robot.conveyor;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public interface ConveyorComponents {

    WPI_TalonFX getTriggerMotor();

    WPI_TalonFX getLoaderMotor();
}
