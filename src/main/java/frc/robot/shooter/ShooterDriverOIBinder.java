package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.shooter.commands.ShootByRPM_PID;

import static frc.robot.shooter.ShooterConstants.SPEED;

public class ShooterDriverOIBinder {

    public ShooterDriverOIBinder(Shooter shooter, Trigger shooterTrigger) {
        shooterTrigger.whileActiveContinuous(new ShootByRPM_PID(shooter,()-> SPEED));
    }
}
