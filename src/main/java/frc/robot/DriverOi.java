package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.exampleSubsystem.ExampleSubsystem;
import frc.robot.exampleSubsystem.ExampleSubsystemDriverOiBinder;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    final XboxController xboxController;

    public DriverOi() {
        xboxController = new XboxController(DRIVE_JOYSTICK_PORT);
    }

    public DriverOi withExampleSubsystem(ExampleSubsystem exampleSubsystem) {
        Trigger exampleMotorTrigger = new JoystickButton(xboxController, XboxController.Button.kB.value);
        new ExampleSubsystemDriverOiBinder(exampleSubsystem, exampleMotorTrigger);
        return this;
    }
}
