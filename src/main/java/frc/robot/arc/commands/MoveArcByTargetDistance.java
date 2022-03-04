package frc.robot.arc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arc.Arc;

import java.util.function.DoubleSupplier;

public class MoveArcByTargetDistance extends CommandBase {

    private final Arc arc;
    private final DoubleSupplier distanceSupplier;

    public MoveArcByTargetDistance(Arc arc, DoubleSupplier distanceSupplier) {
        this.arc = arc;
        this.distanceSupplier = distanceSupplier;
    }

    @Override
    public void initialize() {
        arc.initMoveArcByDistance(distanceSupplier.getAsDouble());
    }

    @Override
    public void execute() {
        arc.updateMoveArcByDistance(distanceSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        arc.stop();
    }
}
