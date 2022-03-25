package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;

import java.util.function.DoubleSupplier;

import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_ARMS_SPEED_STAGE_ONE;
import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_PITCH_ANGLE_STAGE_ONE;

public class ClimbWithArmsStageOneUntilPitch extends ParallelDeadlineGroup {

    public ClimbWithArmsStageOneUntilPitch(AdvancedClimber advancedClimber, Arms arms, DoubleSupplier desiredPitchAngleStageOne) {
        super(new WaitUntilClimbedByPitch(advancedClimber, desiredPitchAngleStageOne),
                new MoveArmsBySpeed(arms, () -> DESIRED_ARMS_SPEED_STAGE_ONE));
    }
}
