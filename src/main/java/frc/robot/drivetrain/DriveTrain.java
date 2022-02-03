package frc.robot.drivetrain;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.drivetrain.DriveTrainConstants.*;

public class DriveTrain extends SubsystemBase {

    private final DriveTrainComponents driveTrainComponents;

    public DriveTrain(DriveTrainComponents driveTrainComponents) {
        this.driveTrainComponents = driveTrainComponents;
        resetEncoders();
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
    }

    public void arcadeDrive(double speed, double rotation) {
        driveTrainComponents.getDifferentialDrive().arcadeDrive(speed, rotation);
    }

    public void stop() {
        driveTrainComponents.getLeftMasterMotor().stopMotor();
        driveTrainComponents.getRightMasterMotor().stopMotor();
    }

    public Pose2d getPose() {
        return driveTrainComponents.getOdometry().getPoseMeters();
    }

    private double encoderUnitsToMeters(double units) {
        return units * PERIMETER_METER / ENCODER_UNITS_PER_ROTATION;
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
