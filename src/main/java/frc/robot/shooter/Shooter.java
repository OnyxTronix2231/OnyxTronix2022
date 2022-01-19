package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.shooter.ShooterConstants.DECI_SECONDS_PER_MINUTE;
import static frc.robot.shooter.ShooterConstants.ENCODER_UNITS_PER_ROUND;

public class Shooter extends SubsystemBase {

    private ShooterComponents shooterComponents;

    public Shooter(ShooterComponents shooterComponents){
        this.shooterComponents = shooterComponents;
    }

    public void setSpeed(double speed){
        shooterComponents.getMasterMotor().set(speed);
    }

    public double rpmToEncoderUnitsInDecisecond(double rpm){
        return (rpm* ENCODER_UNITS_PER_ROUND)/ DECI_SECONDS_PER_MINUTE;
    }

    public void initSetPIDSpeed(double rpm){
        shooterComponents.getController().setSetpoint(rpmToEncoderUnitsInDecisecond(rpm));
        shooterComponents.getController().enable();
    }

    public void updateSetPIDSpeed(double rpm){
        shooterComponents.getController().setSetpoint(rpmToEncoderUnitsInDecisecond(rpm));
    }

    public void stop(){
        setSpeed(0);
    }

}
