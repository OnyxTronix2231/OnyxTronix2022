package frc.robot.arc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arc.Arc;

import java.util.function.DoubleSupplier;

import static frc.robot.arc.ArcConstants.ArcCalculations.getAngleFromTargetDistance;
import static frc.robot.arc.ArcConstants.ArcCalculations.getLinearServoPositionFromAngle;

public class MoveArcByDistance extends CommandBase {

    private final Arc arc;
    private final DoubleSupplier distanceSupplier;

    public MoveArcByDistance(Arc arc, DoubleSupplier distanceSupplier) {
        this.arc = arc;
        this.distanceSupplier = distanceSupplier;
        addRequirements(arc);
    }

    @Override
    public void execute() {
        arc.setPos(getLinearServoPositionFromAngle(getAngleFromTargetDistance(distanceSupplier.getAsDouble())));
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
