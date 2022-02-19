package frc.robot;

import humanControls.ConsoleController;
import humanControls.OnyxXboxController;

import static frc.robot.Constants.Deputy_JOYSTICK_PORT;

public class DeputyOi {

    final ConsoleController controller;

    public DeputyOi() {
        controller = new OnyxXboxController(Deputy_JOYSTICK_PORT);
    }
}
