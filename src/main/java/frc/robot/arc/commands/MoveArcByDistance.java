package frc.robot.arc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arc.Arc;
import frc.robot.arc.ArcConstants;
import java.util.function.DoubleSupplier;

public class MoveArcByDistance extends MoveArcToAngle {

    public MoveArcByDistance(Arc arc, DoubleSupplier distanceSupplier) {
        super(arc, () -> ArcConstants.ArcCalculations.distanceToAngle(distanceSupplier.getAsDouble()));
    }
}
