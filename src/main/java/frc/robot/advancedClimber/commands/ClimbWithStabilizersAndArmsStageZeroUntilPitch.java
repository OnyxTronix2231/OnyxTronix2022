package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;

import java.util.function.DoubleSupplier;

import static frc.robot.advancedClimber.AdvancedClimberConstants.*;

public class ClimbWithStabilizersAndArmsStageZeroUntilPitch extends ParallelDeadlineGroup {

    public ClimbWithStabilizersAndArmsStageZeroUntilPitch(AdvancedClimber advancedClimber, Arms arms, DoubleSupplier desiredPitchAngleStageZero) {
        super(new WaitUntilClimbedByPitch(advancedClimber, desiredPitchAngleStageZero),
                new MoveArmsBySpeed(arms, () -> DESIRED_ARMS_SPEED_STAGE_ONE),
                new MoveStabilizerBySpeed(advancedClimber, () -> DESIRED_STABILIZER_SPEED_STAGE_TWO));
    }
}
