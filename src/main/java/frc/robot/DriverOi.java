package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriverDriveTrainOiBinders;
import frc.robot.intake.Intake;
import frc.robot.intake.IntakeOiBinder;
import humanControls.JoystickAxis;
import onyxTronix.JoystickAxis;


import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;


public class DriverOi {

    final XboxController xboxController;

    public DriverOi() {
        xboxController = new XboxController(DRIVE_JOYSTICK_PORT);
    }

    public DriverOi withDriveTrain(DriveTrain driveTrain) {
        JoystickAxis leftJoystick = new JoystickAxis(xboxController, XboxController.Axis.kLeftY.value);
        JoystickAxis rightJoystick = new JoystickAxis(xboxController, XboxController.Axis.kRightX.value);
        new DriverDriveTrainOiBinders(driveTrain, leftJoystick, rightJoystick);
        return this;
    }

    public DriverOi withBackIntake(Intake intake) {
        JoystickButton openAndIntake = new JoystickButton(xboxController, XboxController.Button.kX.value);
        new IntakeOiBinder(intake, openAndIntake);
        return this;
    }
    public DriverOi withForwardIntake(Intake intake) {
        JoystickButton openAndIntake = new JoystickButton(xboxController, XboxController.Button.kA.value);
        new IntakeOiBinder(intake, openAndIntake);
        return this;
    }
}
