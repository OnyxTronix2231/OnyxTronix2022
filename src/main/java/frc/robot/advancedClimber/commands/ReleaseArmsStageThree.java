package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_ARMS_SPEED_STAGE_THREE;
import static frc.robot.advancedClimber.AdvancedClimberConstants.KEEP_STABILIZER_SPEED;

public class ReleaseArmsStageThree extends SequentialCommandGroup {

    public ReleaseArmsStageThree(AdvancedClimber advancedClimber, Arms arms) {
        super(new KeepStabilizersToReleaseArms(advancedClimber, arms,() -> KEEP_STABILIZER_SPEED).withTimeout(0.5),
                new FinishClimb(advancedClimber, arms));
    }
}
