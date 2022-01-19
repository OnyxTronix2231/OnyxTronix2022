package frc.robot.ShooterWood;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Shooter.ShooterConstants.*;

public class Shooter extends SubsystemBase {

    private ShooterComponents shooterComponents;

    public Shooter(ShooterComponents shooterComponents) {
        this.shooterComponents = shooterComponents;
    }

    public void setSpeed(double speed) {
        shooterComponents.getMasterMotor().set(speed);
    }

    public void stop() {
        setSpeed(0);
    }

    public double RPMToEncoderUnitsInDecisecond(double rpm) {
        return (rpm * ENCODER_UNITS_PER_ROUND) / DECISECONDS_PER_MIN;
    }

    public void initMoveByRPM(double rpm) {
        shooterComponents.getController().setSetpoint(RPMToEncoderUnitsInDecisecond(rpm));
        shooterComponents.getController().enable();
    }

    public void updateMoveByRPM(double rpm){
        shooterComponents.getController().setSetpoint(RPMToEncoderUnitsInDecisecond(rpm));
    }
}
