package frc.robot.arc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arc.Arc;
import java.util.function.DoubleSupplier;

public class MoveLinearServoByDistance extends CommandBase {

    private final Arc arc;
    private final DoubleSupplier distanceSupplier;

    public MoveLinearServoByDistance(Arc arc, DoubleSupplier distanceSupplier) {
        this.arc = arc;
        this.distanceSupplier = distanceSupplier;
        addRequirements(arc);
    }

    @Override
    public void execute() {
        arc.setPosition(distanceSupplier.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        arc.setSpeed(0);
    }
}
