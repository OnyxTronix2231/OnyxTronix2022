package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.shooter.commands.ShootBySpeed;

import static frc.robot.shooter.ShooterConstants.SPEED;

public class DriverShooterOIBinder {

    public DriverShooterOIBinder(Shooter shooter, Trigger shooterTrigger) {
        shooterTrigger.whileActiveContinuous(new ShootBySpeed(shooter, () -> SPEED));
    }
}
