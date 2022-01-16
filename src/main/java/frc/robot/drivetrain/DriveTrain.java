package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.drivetrain.DriveTrainConstants.ENCODER_UNITS_TO_METER;

public class DriveTrain extends SubsystemBase {

    private final DriveTrainComponents driveTrainComponents;

    public DriveTrain(DriveTrainComponents driveTrainComponents) {
        this.driveTrainComponents = driveTrainComponents;
    }

    public void arcadeDrive(double speed, double rotation) {
        driveTrainComponents.getDifferentialDrive().arcadeDrive(speed, rotation);
    }

    public void stop() {
        driveTrainComponents.getLeftMasterMotor().stopMotor();
        driveTrainComponents.getRightMasterMotor().stopMotor();
    }

    public void driveByDistance(double distance) {
        driveTrainComponents.getLeftMasterMotor().set(ControlMode.MotionMagic, distance * ENCODER_UNITS_TO_METER);
        driveTrainComponents.getRightMasterMotor().set(ControlMode.MotionMagic, distance * ENCODER_UNITS_TO_METER);
    }
    
}
