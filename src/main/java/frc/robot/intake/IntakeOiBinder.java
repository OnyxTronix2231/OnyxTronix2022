package frc.robot.intake;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.intake.commands.CloseSolenoid;
import frc.robot.intake.commands.IntakeBySpeed;
import frc.robot.intake.commands.OpenAndIntake;
import frc.robot.intake.commands.OpenSolenoid;

import java.util.stream.Collector;

public class IntakeOiBinder {

    public IntakeOiBinder(Intake intake, JoystickButton intakeBySpeed,JoystickButton openAndIntake,JoystickButton closeSolenoid){
        intakeBySpeed.whileActiveContinuous(new IntakeBySpeed(intake,()->0.3));
        openAndIntake.whileActiveContinuous(new OpenAndIntake(intake,()->0.3));
        closeSolenoid.whileActiveContinuous(new CloseSolenoid(intake));

    }
}
