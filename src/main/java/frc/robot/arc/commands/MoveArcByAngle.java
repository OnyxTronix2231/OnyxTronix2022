package frc.robot.arc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arc.Arc;

import java.util.function.DoubleSupplier;

public class MoveArcByAngle extends CommandBase {

    private Arc arc;
    private DoubleSupplier angle;

    public MoveArcByAngle(Arc arc, DoubleSupplier angle) {
        this.arc = arc;
        this.angle = angle;
        addRequirements(arc);
    }

    public void end(boolean interrupted) {
        arc.stop();
    }
}
