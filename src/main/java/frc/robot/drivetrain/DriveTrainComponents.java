package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import sensors.counter.TalonEncoder;

public interface DriveTrainComponents {

    WPI_TalonFX getLeftMasterMotor();

    WPI_TalonFX getRightMasterMotor();

    DifferentialDrive getDifferentialDrive();

    DifferentialDriveOdometry getOdometry();

    NormalizedPigeonIMU getNormelizedPigeonIMU();

    TalonEncoder getLeftEncoder();

    TalonEncoder getRightEncoder();

    Field2d getField();

    void setNeutralMode(NeutralMode mode);
}
