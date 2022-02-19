package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

import java.util.function.DoubleSupplier;

import static frc.robot.drivetrain.DriveTrainConstants.*;

public class DriveTrain extends SubsystemBase {

    private final DriveTrainComponents driveTrainComponents;
    public double forwardJoystickValue;

    public DriveTrain(DriveTrainComponents driveTrainComponents) {
        this.driveTrainComponents = driveTrainComponents;
        resetOdometryToPose(new Translation2d(7, 9));
    }

    public void resetEncoders() {
        driveTrainComponents.getLeftEncoder().reset();
        driveTrainComponents.getRightEncoder().reset();
        driveTrainComponents.getNormelizedPigeonIMU().reset();
    }

    @Override
    public void periodic() {
        driveTrainComponents.getOdometry().update(
                Rotation2d.fromDegrees(getHeading()),
                Calculations.encoderUnitsToMeters(driveTrainComponents.getLeftMasterMotor().getSelectedSensorPosition()),
                Calculations.encoderUnitsToMeters(driveTrainComponents.getRightMasterMotor().getSelectedSensorPosition()));
        driveTrainComponents.getField().setRobotPose(driveTrainComponents.getOdometry().getPoseMeters());
        SmartDashboard.updateValues();
    }

    public void arcadeDrive(double speed, double rotation) {
        driveTrainComponents.getDifferentialDrive().arcadeDrive(speed, rotation);
        forwardJoystickValue = speed;
    }

    public void stop() {
        driveTrainComponents.getDifferentialDrive().stopMotor();
    }

    public Pose2d getPose() {
        return driveTrainComponents.getOdometry().getPoseMeters();
    }

    public DifferentialDriveWheelSpeeds getWheelSpeeds() {
        return new DifferentialDriveWheelSpeeds(Calculations.encoderUnitsDeciSecToMetersSec(
                        driveTrainComponents.getLeftMasterMotor().getSelectedSensorVelocity()),
                        Calculations.encoderUnitsDeciSecToMetersSec(driveTrainComponents.getRightMasterMotor().getSelectedSensorVelocity()));
    }

    public double getRobotSpeedMPS() {
        return ((getWheelSpeeds().leftMetersPerSecond + getWheelSpeeds().rightMetersPerSecond) / 2);
    }

    public void tankDriveVolts(double leftVolts, double rightVolts) {
        driveTrainComponents.getLeftMasterMotor().set(leftVolts / VOLTS);
        driveTrainComponents.getRightMasterMotor().set(rightVolts / VOLTS);
        driveTrainComponents.getDifferentialDrive().feed();
    }

    public double getHeading() {
        return driveTrainComponents.getNormelizedPigeonIMU().getRawYaw();
    }

    public void resetOdometryToPose(Translation2d translation) {
        resetOdometryToPose(new Pose2d(translation, this.getPose().getRotation()));
    }

    public void setNeutralModeToCoast() {
        driveTrainComponents.setNeutralMode(NeutralMode.Coast);
    }

    public void setNeutralModeToBrake() {
        driveTrainComponents.setNeutralMode(NeutralMode.Brake);
    }

    public void resetOdometryToPose(Pose2d pose) {
        resetEncoders();
        driveTrainComponents.getOdometry().resetPosition(pose, pose.getRotation());
        driveTrainComponents.getNormelizedPigeonIMU().setYaw(pose.getRotation().getDegrees());
    }

    public double getForwardJoystickValue() {
        return forwardJoystickValue;
    }
}
