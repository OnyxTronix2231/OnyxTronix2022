package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;

import java.util.function.DoubleSupplier;

public class AutoClimb extends ParallelDeadlineGroup {

    public AutoClimb(AdvancedClimber advancedClimber, Arms arms, DoubleSupplier stabilizerSpeedSupplier,
                     DoubleSupplier armsSpeedSuppler) {
        super(new WaitUntilClimbedByRoll(advancedClimber),
                new MoveStabilizerBySpeed(advancedClimber, stabilizerSpeedSupplier),
                new MoveArmsBySpeed(arms, armsSpeedSuppler));
    }
}
