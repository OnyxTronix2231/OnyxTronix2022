package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.stabilizers.commands.MoveStabilizerUntilOnPosition;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_ARMS_SPEED_STAGE_ONE;
import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_STABILIZER_SPEED_STAGE_ZERO;

public class MoveNow extends ParallelDeadlineGroup {

    public MoveNow(AdvancedClimber advancedClimber, Arms arms,
                   DoubleSupplier desiredPitchAngleStageZero
    ) {
        super(new MoveArmsUntilOnPitch(advancedClimber, arms, () -> DESIRED_ARMS_SPEED_STAGE_ONE, desiredPitchAngleStageZero)
        );
    }
}