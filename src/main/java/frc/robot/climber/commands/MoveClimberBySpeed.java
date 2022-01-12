package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;
// imports

public class MoveClimberBySpeed extends CommandBase {

    private final Climber climber; // הגדרת תכונות
    private final DoubleSupplier speedSupplier;

    public MoveClimberBySpeed(Climber climber, DoubleSupplier speedSupplier) {// constructor
        this.climber = climber;
        this.speedSupplier = speedSupplier;
        addRequirements(climber);
    }

    @Override
    public void execute() {
        climber.moveBySpeed(speedSupplier.getAsDouble()); // when the command is executed the climber(rail) moves
    }

    @Override
    public void end(boolean interrupted) {
        climber.stopMotors(); // when the command end, the motors should stop
    }
}
