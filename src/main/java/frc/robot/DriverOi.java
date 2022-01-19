package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.ShooterWood.ShooterWood;
import frc.robot.ShooterWood.ShooterWoodDriverOiBinder;

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
}
