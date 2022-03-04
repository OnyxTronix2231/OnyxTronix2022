package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.TARGET_POSE_X;
import static frc.robot.Constants.TARGET_POSE_Y;
import static frc.robot.drivetrain.DriveTrainConstants.*;
import static frc.robot.turret.TurretConstants.DEG_IN_HALF_CIRCLE;
import static frc.robot.turret.TurretConstants.TARGET_POS;

public class DriveTrain extends SubsystemBase {
    private final DriveTrainComponents driveTrainComponents;
    public double forwardSpeedValue;
    private Field2d field2d;

    public DriveTrain(DriveTrainComponents driveTrainComponents) {
        this.driveTrainComponents = driveTrainComponents;
        field2d = new Field2d();
    }

    public void resetEncoders() {
        driveTrainComponents.getLeftEncoder().reset();
        driveTrainComponents.getRightEncoder().reset();
        driveTrainComponents.getNormalizedPigeonIMU().reset();
    }

    @Override
    public void periodic() {
        driveTrainComponents.getOdometry().update(
                Rotation2d.fromDegrees(getHeading()),
                Calculations.encoderUnitsToMeters(driveTrainComponents.getLeftMasterMotor().getSelectedSensorPosition()),
                Calculations.encoderUnitsToMeters(driveTrainComponents.getRightMasterMotor().getSelectedSensorPosition()));
        getField().setRobotPose(driveTrainComponents.getOdometry().getPoseMeters());
    }

    public void arcadeDrive(double speed, double rotation) {
        forwardSpeedValue = speed * SPEED_SENSITIVITY;
        driveTrainComponents.getDifferentialDrive().arcadeDrive(forwardSpeedValue, rotation * ROTATION_SENSITIVITY);
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
        DifferentialDriveWheelSpeeds currentSpeed = getWheelSpeeds();
        return Calculations.getAverageSpeed(currentSpeed.leftMetersPerSecond, currentSpeed.rightMetersPerSecond);
    }

    public void tankDriveVolts(double leftVolts, double rightVolts) {
        driveTrainComponents.getLeftMasterMotor().set(leftVolts / VOLTS);
        driveTrainComponents.getRightMasterMotor().set(rightVolts / VOLTS);
        driveTrainComponents.getDifferentialDrive().feed();
    }

    public double getHeading() {
        return driveTrainComponents.getNormalizedPigeonIMU().getRawYaw();
    }

    public double getPitch() { return driveTrainComponents.getNormalizedPigeonIMU().getRawYaw(); }

    public void resetOdometryToPose(Translation2d translation) {
        resetOdometryToPose(new Pose2d(translation, this.getPose().getRotation()));
    }

    public double getDistanceFromTargetByEncoders() {
        Pose2d currentPose = getPose();
        return (Math.sqrt(Math.pow((currentPose.getX() - TARGET_POSE_X), 2)
                + Math.pow((currentPose.getY() - TARGET_POSE_Y), 2)));
    }

    public double getAngleToTargetByPose() {
        Pose2d currentPos = getPose();
        double angle = Math.toDegrees(Math.atan(-(currentPos.getY() - TARGET_POSE_Y) /
                (currentPos.getX() - TARGET_POSE_X)));
        if (currentPos.getX() > TARGET_POSE_X)
            angle += DEG_IN_HALF_CIRCLE;
        return angle;
    }

    public Field2d getField() {
        return field2d;
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
        driveTrainComponents.getNormalizedPigeonIMU().setYaw(pose.getRotation().getDegrees());
    }

    public double getForwardSpeedValue() {
        return forwardSpeedValue;
    }
}
