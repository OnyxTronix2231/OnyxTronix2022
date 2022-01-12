package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public interface DriveTrainComponents {

    WPI_TalonFX getLeftMasterMotor();

    WPI_TalonFX getLeftSlaveMotor();

    WPI_TalonFX getRightMasterMotor();

    WPI_TalonFX getRightSlaveMotor();

    DifferentialDrive getDifferentialDrive();
}
