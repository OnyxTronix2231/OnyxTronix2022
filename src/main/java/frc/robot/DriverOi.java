package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.Climber;
import frc.robot.climber.ClimberDriverOiBinder;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    final XboxController xboxController;

    public DriverOi() {
        xboxController = new XboxController(DRIVE_JOYSTICK_PORT);
    }
    public DriverOi withClimberOi(Climber climber){
        Trigger microSwitchTest = new JoystickButton(xboxController,XboxController.Button.kA.value);
        new ClimberDriverOiBinder(climber, microSwitchTest);
        return this;
    }
}
