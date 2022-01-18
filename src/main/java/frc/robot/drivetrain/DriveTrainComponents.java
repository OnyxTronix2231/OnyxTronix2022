package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import pid.CtreMotionMagicController;
import sensors.counter.CtreEncoder;

public interface DriveTrainComponents {

    WPI_TalonFX getLeftMasterMotor();

    WPI_TalonFX getLeftSlaveMotor();

    WPI_TalonFX getRightMasterMotor();

    WPI_TalonFX getRightSlaveMotor();

    DifferentialDrive getDifferentialDrive();

    DifferentialDriveOdometry getOdometry();

    NormalizedPigeonIMU getNormelizedPigeonIMU();

    CtreEncoder getLeftEncoder();

    CtreEncoder getRightEncoder();

    CtreMotionMagicController getLeftController();

    CtreMotionMagicController getRightController();

}
