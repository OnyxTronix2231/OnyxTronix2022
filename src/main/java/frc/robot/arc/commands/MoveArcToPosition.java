package frc.robot.arc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arc.Arc;
import java.util.function.DoubleSupplier;

public class MoveArcToPosition extends CommandBase {

    private final Arc arc;
    private final DoubleSupplier positionSupplier;

    public MoveArcToPosition(Arc arc, DoubleSupplier positionSupplier) {
        this.arc = arc;
        this.positionSupplier = positionSupplier;
        addRequirements(arc);
    }

    @Override
    public void execute() {
        arc.setPosition(positionSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        arc.setSpeed(0);
    }
}
