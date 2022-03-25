package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;

import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_ARMS_SPEED_STAGE_ONE;
import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_PITCH_ANGLE_STAGE_ONE;

public class ClimbWithArmsStageOneUntilPitch extends ParallelDeadlineGroup {

    public ClimbWithArmsStageOneUntilPitch(AdvancedClimber advancedClimber, Arms arms) {
        super(new WaitUntilClimbedByPitch(advancedClimber, () -> DESIRED_PITCH_ANGLE_STAGE_ONE),
                new MoveArmsBySpeed(arms, () -> DESIRED_ARMS_SPEED_STAGE_ONE));
    }
}
