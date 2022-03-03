package frc.robot;

import humanControls.ConsoleController;
import humanControls.OnyxXboxController;

import static frc.robot.Constants.DEPUTY_JOYSTICK_PORT;

public class DeputyOi {

    final ConsoleController controller;

    public DeputyOi() {
        controller = new OnyxXboxController(DEPUTY_JOYSTICK_PORT);
    }
}
