package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.Climber;
import frc.robot.climber.DeputeClimberOiBinder;
import humanControls.ConsoleController;
import humanControls.JoystickAxis;
import humanControls.OnyxXboxController;
import humanControls.PlayStation5Controller;

import static frc.robot.Constants.DEPUTY_JOYSTICK_PORT;

public class DeputyOi {

    final ConsoleController controller;

    public DeputyOi() {
        controller = new PlayStation5Controller(DEPUTY_JOYSTICK_PORT);
    }

    public DeputyOi withClimber(Climber climber){
        JoystickAxis climb = new JoystickAxis(controller, controller.getAxisLeftY());
        Trigger open = new JoystickButton(controller, controller.getButtonUp());
        Trigger down = new JoystickButton(controller, controller.getButtonDown());
        Trigger moveRightArmSlow = new JoystickButton(controller, controller.getButtonRight());
        Trigger moveLeftArmSlow = new JoystickButton(controller, controller.getButtonLeft());
        JoystickAxis moveLeftArm = new JoystickAxis(controller, controller.getAxisRightY());
        new DeputeClimberOiBinder(climber, down, open, climb, moveRightArmSlow, moveLeftArmSlow, moveLeftArm);
        return this;
    }
}
