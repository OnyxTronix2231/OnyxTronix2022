package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;

public class ClimbUntilReachedEncoderPosition extends ParallelDeadlineGroup {

    public ClimbUntilReachedEncoderPosition(Climber climber, DoubleSupplier speedSupplier) {
        super(new WaitUntilClimbedByEncoder(climber), new ClimbBySpeed(climber, speedSupplier));
    }
}
