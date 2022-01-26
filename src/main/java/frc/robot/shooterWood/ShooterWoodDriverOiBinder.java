package frc.robot.shooterWood;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.shooterWood.commands.ShootByRPMWood;

public class ShooterWoodDriverOiBinder {

            public ShooterWoodDriverOiBinder(ShooterWood shooterWood, Trigger shootBySpeed) {
                shootBySpeed.whileActiveContinuous(new ShootByRPMWood(shooterWood, () -> shooterWood.getSpeed()));
    }
}
