package frc.robot.arc.commands;

import frc.robot.arc.Arc;
import java.util.function.DoubleSupplier;

import static frc.robot.arc.ArcConstants.ArcCalculations.distanceToAngle;

public class MoveArcTargetDistance extends MoveArcToAngle {

    public MoveArcTargetDistance(Arc arc, DoubleSupplier distanceSupplier) {
        super(arc, () -> distanceToAngle(distanceSupplier.getAsDouble()));
    }
}
