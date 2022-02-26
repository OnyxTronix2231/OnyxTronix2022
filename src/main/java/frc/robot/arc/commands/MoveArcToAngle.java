package frc.robot.arc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arc.Arc;

import java.util.function.DoubleSupplier;

public class MoveArcToAngle extends CommandBase {

    private final Arc arc;
    private final DoubleSupplier distanceSupplier;

    public MoveArcToAngle(Arc arc, DoubleSupplier distanceSupplier) {
        this.arc = arc;
        this.distanceSupplier = distanceSupplier;
        addRequirements(arc);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        arc.setSpeed(0);
    }
}
