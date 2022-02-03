package frc.robot.arc.commands;

import frc.robot.arc.Arc;
import frc.robot.arc.ArcConstants;

import java.util.function.DoubleSupplier;

public class MoveArcToAngle extends MoveLinearServoByDistance {

    public MoveArcToAngle(Arc arc, DoubleSupplier angleSupplier) {
        super(arc, () -> ArcConstants.ArcCalculations.getLinearServoPositionFromAngle(angleSupplier.getAsDouble()));
    }
}
