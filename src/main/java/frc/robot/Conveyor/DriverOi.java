package frc.robot.Conveyor;

import edu.wpi.first.wpilibj.XboxController;

import static frc.robot.Conveyor.Constants.DRIVE_JOYSTICK_PORT;

public class DriverOi {
    final XboxController driverXboxController;

    public DriverOi() {driverXboxController = new XboxController(DRIVE_JOYSTICK_PORT);}
}
