package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;

import java.util.function.DoubleSupplier;

import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_ARMS_SPEED_RELEASE;
import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_ARMS_SPEED_STAGE_THREE;

public class KeepStabilizersToReleaseArms extends ParallelCommandGroup {

    public KeepStabilizersToReleaseArms(AdvancedClimber advancedClimber, Arms arms, DoubleSupplier keepStabilizersSpeed) {
        super(new MoveStabilizerBySpeed(advancedClimber, keepStabilizersSpeed),
                new MoveArmsBySpeed(arms, () -> DESIRED_ARMS_SPEED_RELEASE));
    }
}
