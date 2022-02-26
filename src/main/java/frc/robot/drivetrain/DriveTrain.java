package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.crossPlatform.autonomousCommands.pathCommands.*;

import static frc.robot.drivetrain.DriveTrainConstants.*;

public class DriveTrain extends SubsystemBase {

    private final DriveTrainComponents driveTrainComponents;
    public double forwardJoystickValue;
    private Field2d field2d;

    public DriveTrain(DriveTrainComponents driveTrainComponents) {
        this.driveTrainComponents = driveTrainComponents;
        field2d = new Field2d();
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
        getField().setRobotPose(driveTrainComponents.getOdometry().getPoseMeters());
        SmartDashboard.updateValues();
    }

    public void arcadeDrive(double speed, double rotation) {
        forwardJoystickValue = speed * SPEED_SENSITIVITY;
        driveTrainComponents.getDifferentialDrive().arcadeDrive(forwardJoystickValue, rotation * ROTATION_SENSITIVITY);
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
        return getAverageSpeed;
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

    public Field2d getField() {
        return field2d;
    }

    public void setNeutralMode(NeutralMode mode) {
        driveTrainComponents.getLeftMasterMotor().setNeutralMode(mode);
        driveTrainComponents.getRightMasterMotor().setNeutralMode(mode);
    }

    public void setNeutralModeToCoast() {
        setNeutralMode(NeutralMode.Coast);
    }

    public void setNeutralModeToBrake() {
        setNeutralMode(NeutralMode.Brake);
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
