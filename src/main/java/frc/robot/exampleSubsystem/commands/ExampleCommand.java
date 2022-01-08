package frc.robot.exampleSubsystem.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.exampleSubsystem.ExampleSubsystem;

import static frc.robot.exampleSubsystem.ExampleSubsystemConstants.PERCENT_OUTPUT;

public class ExampleCommand extends CommandBase {

    private final ExampleSubsystem exampleSubsystem;

    public ExampleCommand(final ExampleSubsystem exampleSubsystem) {
        this.exampleSubsystem = exampleSubsystem;
        addRequirements(exampleSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        exampleSubsystem.setMotor(PERCENT_OUTPUT);
        System.out.println("FULL POWER!!!!");
    }

    @Override
    public void end(boolean interrupted) {
        exampleSubsystem.stop();
    }
}
