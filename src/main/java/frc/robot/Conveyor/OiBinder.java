package frc.robot.Conveyor;

import edu.wpi.first.wpilibj.XboxController;
import static frc.robot.Conveyor.Constants.DRIVE_JOYSTICK_PORT;

public class OiBinder {

    final XboxController xboxController;

    public OiBinder() {
        xboxController = new XboxController(DRIVE_JOYSTICK_PORT);
    }
}
