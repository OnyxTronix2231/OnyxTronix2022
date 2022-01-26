package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.shooterWood.ShooterWood;
import frc.robot.shooterWood.ShooterWoodDriverOiBinder;
import frc.robot.shooter.Shooter;
import frc.robot.shooter.ShooterDriverOIBinder;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    final XboxController xboxController;

    public DriverOi() {
        xboxController = new XboxController(DRIVE_JOYSTICK_PORT);
    }

    public DriverOi withShooterWood(ShooterWood shooter){
        Trigger shooterTrigger = new JoystickButton(xboxController, XboxController.Button.kA.value);
        new ShooterWoodDriverOiBinder(shooter, shooterTrigger);
        return this;
    }

    public DriverOi withShooter (Shooter shooter){
        Trigger shooterTrigger = new JoystickButton(xboxController, XboxController.Button.kB.value);
        new ShooterDriverOIBinder(shooter, shooterTrigger);
        return this;
    }
}
