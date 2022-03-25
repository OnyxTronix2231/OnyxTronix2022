package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;
import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;

import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_ARMS_SPEED_STAGE_THREE;
import static frc.robot.advancedClimber.AdvancedClimberConstants.RELEASE_ARMS_TIMEOUT;

public class AutoClimb extends SequentialCommandGroup {

    public AutoClimb(AdvancedClimber advancedClimber, Arms arms, Vision vision,DoubleSupplier desiredPitchAngleStageOne, DoubleSupplier desiredPitchAngleStageTwo) {
        super(new ClimbWithArmsStageOneUntilPitch(advancedClimber, arms, desiredPitchAngleStageOne),
                //new ClimbWithStabilizersAndArmsStageTwoUntilPitch(advancedClimber, arms, desiredPitchAngleStageTwo),
//                new ReleaseArmsStageThree(advancedClimber, arms).withTimeout(RELEASE_ARMS_TIMEOUT),
                new EveryoneClaps(vision));
    }
}
