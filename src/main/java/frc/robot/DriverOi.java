package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.intake.Intake;
import frc.robot.intake.IntakeOiBinder;
import frc.robot.intake.commands.OpenAndIntake;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;


public class DriverOi {

    final XboxController xboxController;

    public DriverOi() {
        xboxController = new XboxController(DRIVE_JOYSTICK_PORT);
    }

    public DriverOi morningWoodTest(Intake intake){
        JoystickButton intakeBySpeed = new JoystickButton(xboxController,XboxController.Button.kY.value);
        JoystickButton openAndIntake = new JoystickButton(xboxController,XboxController.Button.kA.value );
        JoystickButton closeSolenoid = new JoystickButton(xboxController,XboxController.Button.kX.value);
        new IntakeOiBinder(intake,intakeBySpeed,openAndIntake,closeSolenoid);
        return this;
    }

}
