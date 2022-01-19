package frc.robot.ShooterWood;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Shooter.Commands.ShootBySpeed;

import static frc.robot.Shooter.ShooterConstants.SPEED;

public class ShooterDriverOiBinder {

    public ShooterDriverOiBinder (Shooter shooter, Trigger shootBySpeed) {
        shootBySpeed.whileActiveContinuous(new ShootBySpeed(shooter, SPEED));
    }
}
