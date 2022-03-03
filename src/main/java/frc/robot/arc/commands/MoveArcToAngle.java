package frc.robot.arc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arc.Arc;

import java.util.function.DoubleSupplier;

public class MoveArcToAngle extends CommandBase {

    private final Arc arc;
    private final DoubleSupplier angleSupplier;

    public MoveArcToAngle(Arc arc, DoubleSupplier angleSupplier) {
        this.arc = arc;
        this.angleSupplier = angleSupplier;
        addRequirements(arc);
    }

    public void initialize() {
        arc.initMoveToAngle(angleSupplier.getAsDouble());
    }

    @Override
    public void execute() {
        arc.updateMoveToAngle(angleSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        arc.setSpeed(0);
    }
}
