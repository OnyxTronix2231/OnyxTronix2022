package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

import static frc.robot.Constants.Deputy_JOYSTICK_PORT;

public class DeputyOi {

    final XboxController xboxController;

    public DeputyOi() {
        xboxController = new XboxController(Deputy_JOYSTICK_PORT);
    }
}
