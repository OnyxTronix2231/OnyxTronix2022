package frc.robot.ShooterWood;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.ShooterWood.Commands.ShootBySpeedWood;

import static frc.robot.ShooterWood.ShooterWoodConstants.SPEED;

        public class ShooterWoodDriverOiBinder {

            public ShooterWoodDriverOiBinder(ShooterWood shooterWood, Trigger shootBySpeed) {
                shootBySpeed.whileActiveContinuous(new ShootBySpeedWood(shooterWood, () -> shooterWood.getSpeed()));
    }
}
