package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.shooter.ShooterConstants.*;

public class Shooter extends SubsystemBase {

    private ShooterComponents shooterComponents;

    public Shooter(ShooterComponents shooterComponents) {
        this.shooterComponents = shooterComponents;
    }

    public void setSpeed(double speed) {
        shooterComponents.getMasterMotor().set(speed);
    }

    public double rpmToEncoderUnitsInDecisecond(double rpm) {
        return (rpm * ENCODER_UNITS_PER_ROUND) / DECI_SECONDS_PER_MINUTE;
    }

    public double rpmToMetersPerSec(double rpm) {
        return ((2 * Math.PI * SHOOTER_MOTOR_RADIUS) / SEC_IN_MIN * rpm);
    }

    public void initSetPIDSpeed(double rpm) {
        shooterComponents.getController().setSetpoint(rpmToEncoderUnitsInDecisecond(rpm));
        shooterComponents.getController().enable();
    }

    public void updateSetPIDSpeed(double rpm) {
        shooterComponents.getController().setSetpoint(rpmToEncoderUnitsInDecisecond(rpm));
    }

    public void stop() {
        setSpeed(0);
    }
}
