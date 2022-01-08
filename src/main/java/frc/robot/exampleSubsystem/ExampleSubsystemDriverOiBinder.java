package frc.robot.exampleSubsystem;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.exampleSubsystem.commands.ExampleCommand;

public class ExampleSubsystemDriverOiBinder {

    public ExampleSubsystemDriverOiBinder(final ExampleSubsystem exampleSubsystem, final Trigger exampleMotorTrigger) {
        exampleMotorTrigger.whileActiveContinuous(new ExampleCommand(exampleSubsystem));
    }
}
