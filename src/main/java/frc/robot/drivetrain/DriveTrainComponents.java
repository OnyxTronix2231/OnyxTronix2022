package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public interface DriveTrainComponents {

    WPI_TalonFX getLeftMasterMotor();

    WPI_TalonFX getLeftSlaveMotor();

    WPI_TalonFX getRightMasterMotor();

    WPI_TalonFX getRightSlaveMotor();
}
