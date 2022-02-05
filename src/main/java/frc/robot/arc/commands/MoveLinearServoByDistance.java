package frc.robot.arc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arc.Arc;

import java.util.function.DoubleSupplier;

public class MoveLinearServoByDistance extends CommandBase {

    private final Arc arc;
    private final DoubleSupplier distance;

    public MoveLinearServoByDistance(Arc arc, DoubleSupplier distance) {
        this.arc = arc;
        this.distance = distance;
    }

    @Override
    public void execute() {
        arc.setPos(distance.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        return arc.isOnTarget();
    }

    @Override
    public void end(boolean interrupted) {
        arc.setSpeed(0);
    }
}
