package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.shooter.ShooterConstants.DECISECONDSPERMINUTE;
import static frc.robot.shooter.ShooterConstants.ENCODERUNITSPERROUND;

public class Shooter extends SubsystemBase {

    private ShooterComponents shooterComponents;

    public Shooter(ShooterComponents shooterComponents){
        this.shooterComponents = shooterComponents;
    }

    public void setSpeed(double speed){
        shooterComponents.getMasterMotor().set(speed);
    }

    public double rpmToEncoderUnitsInDecisecond(double rpm){
        return (rpm*ENCODERUNITSPERROUND)/DECISECONDSPERMINUTE;
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
