package frc.robot.ShooterWood;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.ShooterWood.Commands.ShootByRPMWood;
import frc.robot.ShooterWood.Commands.ShootBySpeedWood;

        public class ShooterWoodDriverOiBinder {

            public ShooterWoodDriverOiBinder(ShooterWood shooterWood, Trigger shootBySpeed) {
                shootBySpeed.whileActiveContinuous(new ShootByRPMWood(shooterWood, () -> shooterWood.getSpeed()));
    }
}
