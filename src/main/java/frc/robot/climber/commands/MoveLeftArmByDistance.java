package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;

public class MoveLeftArmByDistance extends CommandBase {

    private final Climber climber;
    private final DoubleSupplier distanceSupplier;

    public MoveLeftArmByDistance(Climber climber, DoubleSupplier distanceSupplier) {
        this.climber = climber;
        this.distanceSupplier = distanceSupplier;
        addRequirements(this.climber);
    }

    @Override
    public void initialize() {
        climber.initMoveLeftArmByDistance(distanceSupplier.getAsDouble());
    }

    @Override
    public void execute() {
        climber.updateMoveLeftArmByDistance(distanceSupplier.getAsDouble());
    }

    @Override
    public boolean isFinished() {
       return climber.isLeftArmOnTarget();
    }

    @Override
    public void end(boolean interrupted) {
        climber.stopArmLeftMotor();
    }
}
