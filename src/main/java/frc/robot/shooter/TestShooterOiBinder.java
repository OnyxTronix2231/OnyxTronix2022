package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.shooter.commands.ShootBySpeed;

import static frc.robot.shooter.ShooterConstants.SPEED;

public class TestShooterOiBinder {

    public TestShooterOiBinder(Shooter shooter, Trigger trigger) {
        trigger.whileActiveContinuous(new ShootBySpeed(shooter, () -> SPEED));
    }
}
