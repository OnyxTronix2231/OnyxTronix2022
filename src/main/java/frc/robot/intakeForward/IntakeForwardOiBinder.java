package frc.robot.intakeForward;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.intakeForward.commands.CloseSolenoid;
import frc.robot.intakeForward.commands.IntakeBySpeed;
import frc.robot.intakeForward.commands.OpenAndIntake;
import frc.robot.intakeForward.commands.OpenSolenoid;

public class IntakeForwardOiBinder {

    public IntakeForwardOiBinder(IntakeForward intakeForward, JoystickButton intakeBySpeed, JoystickButton openSolenoid, JoystickButton closeSolenoid){
        intakeBySpeed.whileActiveContinuous(new IntakeBySpeed(intakeForward,()->0.3));
        openSolenoid.whileActiveContinuous(new OpenSolenoid(intakeForward));
        closeSolenoid.whileActiveContinuous(new CloseSolenoid(intakeForward));

    }
}
