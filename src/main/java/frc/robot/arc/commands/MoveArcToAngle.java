package frc.robot.arc.commands;

import frc.robot.arc.Arc;
import frc.robot.arc.ArcConstants;
import java.util.function.DoubleSupplier;

import static frc.robot.arc.ArcConstants.ArcCalculations.angleToLinearServoPos;

public class MoveArcToAngle extends MoveLinearServoByDistance {

    public MoveArcToAngle(Arc arc, DoubleSupplier angleSupplier) {
        super(arc, () -> angleToLinearServoPos(angleSupplier.getAsDouble()));
    }
}
