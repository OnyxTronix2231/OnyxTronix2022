package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;
import frc.robot.stabilizers.commands.MoveStabilizerUntilOnDeltaPosition;
import frc.robot.stabilizers.commands.WaitUntilStabilizersOnDeltaPositionByEncoder;

import java.util.function.IntSupplier;

import static frc.robot.advancedClimber.AdvancedClimberConstants.*;

public class FinishClimb extends ParallelCommandGroup {

        public FinishClimb(AdvancedClimber advancedClimber, Arms arms, IntSupplier deltaForStabilizerFinish) {
            super(new MoveStabilizerBySpeed(advancedClimber, () -> DESIRED_STABILIZER_SPEED_STAGE_FOUR).withTimeout(1),
                    new MoveArmsBySpeed(arms, () -> DESIRED_ARMS_SPEED_STAGE_THREE).withTimeout(0.5));
        }
    }
