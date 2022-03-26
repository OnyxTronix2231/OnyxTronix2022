package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;

import java.util.function.DoubleSupplier;

public class MoveArmsUntilOnPitchStages extends ParallelDeadlineGroup {

    public MoveArmsUntilOnPitchStages(AdvancedClimber advancedClimber, Arms arms, DoubleSupplier speedSupplier,
                                DoubleSupplier pitchSupplier, int stage) {
        super(new WaitUntilClimbedByPitchStages(advancedClimber, pitchSupplier, stage),
                new MoveArmsBySpeed(arms, speedSupplier));
    }
}
