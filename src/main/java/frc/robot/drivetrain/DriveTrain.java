package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

import static frc.robot.drivetrain.DriveTrainConstants.*;
import static frc.robot.drivetrain.DriveTrainConstants.PERIMETER_METER;
import static frc.robot.drivetrain.DriveTrainConstants.ENCODER_CPR;

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

    public void stopDrive() {
        driveTrainComponents.getLeftMasterMotor().stopMotor();
        driveTrainComponents.getRightMasterMotor().stopMotor();
        driveTrainComponents.getLeftController().disable();
        driveTrainComponents.getRightController().disable();
        driveTrainComponents.getDifferentialDrive().stopMotor();
    }

    public void inItDriveByDistance(double distance) {
        inItMoveByEncoderUnits(Calculations.meterToEncoderUnits(distance));
    }

    public void updateDriveByDistance(double distance){
        updateMoveByEncoderUnits(Calculations.meterToEncoderUnits(distance));
    }

    public void inItMoveByEncoderUnits(double encoderUnits){
        driveTrainComponents.getLeftController().setSetpoint(encoderUnits);
        driveTrainComponents.getRightController().setSetpoint(encoderUnits);
        driveTrainComponents.getLeftController().enable();
        driveTrainComponents.getRightController().enable();
    }

    public void updateMoveByEncoderUnits(double encoderUnits){
        driveTrainComponents.getLeftController().update(encoderUnits);
        driveTrainComponents.getRightController().update(encoderUnits);
    }

    public boolean isOnTarget(){
        return driveTrainComponents.getRightController().isOnTarget(tolerance);
    }

    public Pose2d getPose() {
        return driveTrainComponents.getOdometry().getPoseMeters();
    }

    @Override
    public void periodic() {
        driveTrainComponents.getOdometry().update(
                Rotation2d.fromDegrees(getHeading()),
                encoderUnitsToMeters(driveTrainComponents.getLeftMasterMotor().getSelectedSensorPosition()),
                encoderUnitsToMeters(driveTrainComponents.getRightMasterMotor().getSelectedSensorPosition()));
    }

    public DifferentialDriveWheelSpeeds getWheelSpeeds() {
        return new DifferentialDriveWheelSpeeds(encoderUnitsDeciSecToMetersSec(
                        driveTrainComponents.getLeftMasterMotor().getSelectedSensorVelocity()),
                        encoderUnitsDeciSecToMetersSec(driveTrainComponents.getRightMasterMotor().getSelectedSensorVelocity()));
    }

    private double encoderUnitsToMeters(double units) {
        return units * PERIMETER_METER / ENCODER_CPR;
    }

    private double encoderUnitsDeciSecToMetersSec(double unitsDeciSec) {
        return encoderUnitsToMeters(unitsDeciSec * DECISECOND_IN_SECOND);
    }

    public void tankDriveVolts(double leftVolts, double rightVolts) {
        if (Robot.isReal()) {
            driveTrainComponents.getLeftMasterMotor().set(leftVolts / VOLTS);
            driveTrainComponents.getRightMasterMotor().set(rightVolts / VOLTS);
            driveTrainComponents.getDifferentialDrive().feed();
        }
    }

    public double getHeading() {
        return driveTrainComponents.getNormelizedPigeonIMU().getNormalizedYaw();
    }
    
}
