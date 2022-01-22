package frc.robot.intakeBack;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.intakeForward.IntakeForward;
import frc.robot.intakeForward.commands.CloseSolenoid;
import frc.robot.intakeForward.commands.IntakeBySpeed;
import frc.robot.intakeForward.commands.OpenAndIntake;

public class IntakeBackOiBinder {

    public IntakeBackOiBinder(IntakeForward intake, JoystickButton intakeBySpeed, JoystickButton openAndIntake, JoystickButton closeSolenoid){
        intakeBySpeed.whileActiveContinuous(new IntakeBySpeed(intake,()->0.3));
        openAndIntake.whileActiveContinuous(new OpenAndIntake(intake,()->0.3));
        closeSolenoid.whileActiveContinuous(new CloseSolenoid(intake));

    }

}

