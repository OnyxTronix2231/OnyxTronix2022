package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;

public class MoveRightArmBySpeed extends CommandBase {

    private Climber climber;
    private DoubleSupplier speedSupplier;

    public MoveRightArmBySpeed(Climber climber, DoubleSupplier speedSupplier) {
        this.climber = climber;
        this.speedSupplier = speedSupplier;
        addRequirements(climber);
    }

    @Override
    public void execute() {
        climber.moveRightArmBySpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        climber.stopRightArm();
    }
}