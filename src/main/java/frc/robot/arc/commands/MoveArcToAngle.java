package frc.robot.arc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arc.Arc;
import java.util.function.DoubleSupplier;

import static frc.robot.arc.ArcConstants.ArcCalculations.getLinearServoPositionFromAngle;

public class MoveArcToAngle extends CommandBase {

    private final Arc arc;
    private final DoubleSupplier angleSupplier;

    public MoveArcToAngle(Arc arc, DoubleSupplier angleSupplier) {
        this.arc = arc;
        this.angleSupplier = angleSupplier;
        addRequirements(arc);
    }

    @Override
    public void execute() {
        arc.setPos(getLinearServoPositionFromAngle(angleSupplier.getAsDouble()));
    }

    @Override
    public boolean isFinished() {
        return arc.inPosition();
    }

    @Override
    public void end(boolean interrupted) {
        arc.stop();
    }
}
