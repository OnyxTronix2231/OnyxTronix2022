package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.intakeBack.IntakeBack;
import frc.robot.intakeBack.IntakeBackOiBinder;
import frc.robot.intakeForward.IntakeForward;
import frc.robot.intakeForward.IntakeForwardOiBinder;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;


public class DriverOi {

    final XboxController xboxController;

    public DriverOi() {
        xboxController = new XboxController(DRIVE_JOYSTICK_PORT);
    }

    public DriverOi ForwardWoodTest(IntakeForward intakeForward){
        JoystickButton intakeBySpeed = new JoystickButton(xboxController, XboxController.Axis.kRightTrigger.value);
        JoystickButton openSolenoid = new JoystickButton(xboxController,XboxController.Button.kRightBumper.value);
        JoystickButton closeSolenoid = new JoystickButton(xboxController,XboxController.Button.kY.value);
        new IntakeForwardOiBinder(intakeForward,intakeBySpeed,openSolenoid,closeSolenoid);
        return this;
    }

    public DriverOi BackWoodTest(IntakeBack intakeBack){
        JoystickButton intakeBySpeed = new JoystickButton(xboxController,XboxController.Axis.kLeftTrigger.value);
        JoystickButton openSolenoid = new JoystickButton(xboxController,XboxController.Button.kLeftBumper.value);
        JoystickButton closeSolenoid = new JoystickButton(xboxController,XboxController.Button.kX.value);
        new IntakeBackOiBinder(intakeBack,intakeBySpeed,openSolenoid,closeSolenoid);
        return this;
    }

}
