package frc.robot.drivetrain;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.drivetrain.DriveTrainConstants.*;

public class DriveTrain extends SubsystemBase {

    private final DriveTrainComponents driveTrainComponents;

    public DriveTrain(DriveTrainComponents driveTrainComponents) {
        this.driveTrainComponents = driveTrainComponents;
        resetEncoders();
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
                encoderUnitsToMeters(driveTrainComponents.getLeftMasterMotor().getSelectedSensorPosition()),
                encoderUnitsToMeters(driveTrainComponents.getRightMasterMotor().getSelectedSensorPosition()));
        driveTrainComponents.getField().setRobotPose(driveTrainComponents.getOdometry().getPoseMeters());
        SmartDashboard.updateValues();
    }

    public void arcadeDrive(double speed, double rotation) {
        driveTrainComponents.getDifferentialDrive().arcadeDrive(speed, rotation);
    }

    public void stop() {
        driveTrainComponents.getLeftMasterMotor().stopMotor();
        driveTrainComponents.getRightMasterMotor().stopMotor();
    }

    public void stopDrive() {
        driveTrainComponents.getLeftMasterMotor().stopMotor();
        driveTrainComponents.getRightMasterMotor().stopMotor();
        driveTrainComponents.getLeftController().disable();
        driveTrainComponents.getRightController().disable();
        driveTrainComponents.getDifferentialDrive().stopMotor();
    }

    public void initDriveByDistance(double distance) {
        initMoveByEncoderUnits(Calculations.meterToEncoderUnits(distance));
    }

    public void updateDriveByDistance(double distance) {
        updateMoveByEncoderUnits(Calculations.meterToEncoderUnits(distance));
    }

    public void initMoveByEncoderUnits(double encoderUnits) {
        driveTrainComponents.getLeftController().setSetpoint(encoderUnits);
        driveTrainComponents.getRightController().setSetpoint(encoderUnits);
        driveTrainComponents.getLeftController().enable();
        driveTrainComponents.getRightController().enable();
    }

    public void updateMoveByEncoderUnits(double encoderUnits) {
        driveTrainComponents.getLeftController().update(encoderUnits);
        driveTrainComponents.getRightController().update(encoderUnits);
    }

    public boolean isOnTarget() {
        return driveTrainComponents.getLeftController().isOnTarget(TOLERANCE) && driveTrainComponents.getRightController().isOnTarget(TOLERANCE);
    }

    public Pose2d getPose() {
        return driveTrainComponents.getOdometry().getPoseMeters();
    }

    public DifferentialDriveWheelSpeeds getWheelSpeeds() {
        return new DifferentialDriveWheelSpeeds(encoderUnitsDeciSecToMetersSec(
                        driveTrainComponents.getLeftMasterMotor().getSelectedSensorVelocity()),
                        encoderUnitsDeciSecToMetersSec(driveTrainComponents.getRightMasterMotor().getSelectedSensorVelocity()));
    }

    private double encoderUnitsToMeters(double units) {
        return units * PERIMETER_METER / ENCODER_UNITS_PER_ROTATION;
    }

    private double encoderUnitsDeciSecToMetersSec(double unitsDeciSec) {
        return encoderUnitsToMeters(unitsDeciSec * DECISECOND_IN_SECOND);
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
        resetEncoders();
        Pose2d targetPose = new Pose2d(translation, this.getPose().getRotation());
        driveTrainComponents.getOdometry().resetPosition(targetPose, targetPose.getRotation());
        driveTrainComponents.getNormelizedPigeonIMU().setYaw(targetPose.getRotation().getDegrees());
    }
}
