package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;

import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_ARMS_SPEED_STAGE_THREE;

public class ReleaseArmsStageThree extends ParallelCommandGroup {

    public ReleaseArmsStageThree(AdvancedClimber advancedClimber, Arms arms) {
        super(new MoveStabilizerBySpeed(advancedClimber, () -> DESIRED_ARMS_SPEED_STAGE_THREE),
                new MoveArmsBySpeed(arms, () -> DESIRED_ARMS_SPEED_STAGE_THREE));
    }
}
