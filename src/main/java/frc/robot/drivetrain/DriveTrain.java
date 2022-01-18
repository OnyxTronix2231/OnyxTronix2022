package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.drivetrain.DriveTrainConstants.ENCODER_UNITS_TO_METER;
import static frc.robot.drivetrain.DriveTrainConstants.tolerance;

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
        driveTrainComponents.getLeftController().disable();
        driveTrainComponents.getRightController().disable();
    }

    public void inItDriveByDistance(double distance) {
        inItMoveByEncoderUnits(DriveTrainConstants.Calculations.meterToEncoderUnits(distance));
    }

    public void updateDriveByDistance(double distance){
        updateMoveByEncoderUnits(DriveTrainConstants.Calculations.meterToEncoderUnits(distance));
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



}
