package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;


public class MoveRailByDistance extends CommandBase {

    private final Climber climber;
    private final DoubleSupplier distanceSupplier;

    public MoveRailByDistance(Climber climber, DoubleSupplier distanceSupplier) {
        this.climber = climber;
        this.distanceSupplier = distanceSupplier;
        addRequirements(this.climber);
    }

    @Override
    public void initialize() {
        climber.initMoveRailByDistance(distanceSupplier.getAsDouble());
    }

    @Override
    public void execute() {
        climber.updateMoveRailByDistance(distanceSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        climber.stopRailMotor();
    }
}
