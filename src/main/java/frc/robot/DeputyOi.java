package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.Climber;
import frc.robot.climber.DeputeClimberOiBinder;
import humanControls.ConsoleController;
import humanControls.JoystickAxis;
import humanControls.OnyxXboxController;

import static frc.robot.Constants.DEPUTY_JOYSTICK_PORT;

public class DeputyOi {

    final ConsoleController controller;

    public DeputyOi() {
        controller = new OnyxXboxController(DEPUTY_JOYSTICK_PORT);
    }

    public DeputyOi withClimber(Climber climber){
        JoystickAxis clime = new JoystickAxis(controller, controller.getAxisLeftY());
        Trigger open = new JoystickButton(controller, controller.getButtonUp());
        Trigger down = new JoystickButton(controller, controller.getButtonDown());
        new DeputeClimberOiBinder(climber, down, open, clime);
        return this;
    }
}
