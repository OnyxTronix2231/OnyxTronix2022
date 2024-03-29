package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;
import frc.robot.stabilizers.commands.MoveStabilizerUntilOnPosition;
import frc.robot.stabilizers.commands.MoveStabilizerUntilOnPositionStages;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

import static frc.robot.advancedClimber.AdvancedClimberConstants.*;

public class ClimbWithStabilizersAndArmsStageZeroUntilPitch extends ParallelDeadlineGroup {

    private final AdvancedClimber advancedClimber;

    public ClimbWithStabilizersAndArmsStageZeroUntilPitch(AdvancedClimber advancedClimber, Arms arms,
                                                          DoubleSupplier desiredPitchAngleStageZero,
                                                          IntSupplier positionStabilizer) {
        super(new MoveStabilizerUntilOnPositionStages(advancedClimber, () ->
                        DESIRED_STABILIZER_SPEED_STAGE_ZERO,
                positionStabilizer, 1),
                new MoveArmsUntilOnPitch(advancedClimber,arms, () -> DESIRED_ARMS_SPEED_STAGE_ONE, desiredPitchAngleStageZero)
               );
        this.advancedClimber = advancedClimber;
    }
}
