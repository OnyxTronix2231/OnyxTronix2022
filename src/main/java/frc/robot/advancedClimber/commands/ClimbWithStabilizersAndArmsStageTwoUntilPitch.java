package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;

import static frc.robot.advancedClimber.AdvancedClimberConstants.*;

public class ClimbWithStabilizersAndArmsStageTwoUntilPitch extends ParallelDeadlineGroup {

    public ClimbWithStabilizersAndArmsStageTwoUntilPitch(AdvancedClimber advancedClimber, Arms arms) {
        super(new WaitUntilClimbedByPitch(advancedClimber, () -> DESIRED_PITCH_ANGLE_STAGE_TWO),
                new MoveArmsBySpeed(arms, () -> DESIRED_ARMS_SPEED_STAGE_TWO),
                    new MoveStabilizerBySpeed(advancedClimber, () -> DESIRED_STABILIZER_SPEED_STAGE_TWO));
    }
}
