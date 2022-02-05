package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.shooter.ShooterConstants.*;

public class Shooter extends SubsystemBase {

    private final ShooterComponents shooterComponents;

    public Shooter(ShooterComponents shooterComponents) {
        this.shooterComponents = shooterComponents;
    }

    public void setSpeed(double speed) {
        shooterComponents.getMasterMotor().set(speed);
    }

    public void initSetPIDSpeed(double rpm) {
        shooterComponents.getController().setSetpoint(ShooterCalculations.rpmToEncoderUnitsInDecisecond(rpm));
        shooterComponents.getController().enable();
    }

    public void updateSetPIDSpeed(double rpm) {
        shooterComponents.getController().update(ShooterCalculations.rpmToEncoderUnitsInDecisecond(rpm));
    }

    public void stop() {
        setSpeed(0);
        shooterComponents.getController().disable();
    }
}
