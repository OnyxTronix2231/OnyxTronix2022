package frc.robot.intake;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.intake.commands.CloseSolenoid;

import java.util.stream.Collector;

public class IntakeOiBinder {

    public IntakeOiBinder(Intake intake, JoystickButton closSolenoid){
        closSolenoid.whenActive(new CloseSolenoid(intake));
    }
}
