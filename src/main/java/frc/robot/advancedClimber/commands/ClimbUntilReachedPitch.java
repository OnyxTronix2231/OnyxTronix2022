package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;

import java.util.function.DoubleSupplier;

public class ClimbUntilReachedPitch extends ParallelDeadlineGroup {

    public ClimbUntilReachedPitch(AdvancedClimber advancedClimber, DoubleSupplier speedSupplier) {
        super(new WaitUntilClimbedByPitch(advancedClimber), new MoveStabilizerBySpeed(advancedClimber, speedSupplier));
    }
}
