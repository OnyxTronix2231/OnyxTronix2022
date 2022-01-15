package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;

public class MoveArmByDistance extends CommandBase {

    private final Climber climber;
    private final DoubleSupplier distanceSupplier;

    public MoveArmByDistance(Climber climber, DoubleSupplier distanceSupplier) {
        this.climber = climber;
        this.distanceSupplier = distanceSupplier;
        addRequirements(this.climber);
    }

    @Override
    public void initialize() {
        climber.initMoveArmByDistance(distanceSupplier.getAsDouble());
    }

    @Override
    public void execute() {
        climber.updateMoveArmByDistance(distanceSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        climber.stopArmMotor();
    }
}

