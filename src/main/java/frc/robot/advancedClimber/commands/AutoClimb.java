package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;
import frc.robot.arms.commands.MoveArmsBySpeed;
import frc.robot.arms.commands.MoveArmsUntilOnPosition;
import frc.robot.providers.ButtonProvider;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;
import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

import static frc.robot.advancedClimber.AdvancedClimberConstants.*;

public class AutoClimb extends SequentialCommandGroup {

    public AutoClimb(AdvancedClimber advancedClimber, Arms arms, Vision vision, DoubleSupplier desiredPitchAngleStageOne,
                     DoubleSupplier desiredPitchAngleStageTwo, DoubleSupplier desiredPitchAngleStageZero,
                     IntSupplier stabilizerPosition, DoubleSupplier desiredArmsSpeed,
                     IntSupplier desiredArmsDelta, DoubleSupplier keepStabilizerSpeed,
                     ButtonProvider buttonProvider) {
        super(
                new ClimbWithArmsStageOneUntilPitch(advancedClimber, arms, desiredPitchAngleStageOne),
                new ClimbWithStabilizersAndArmsStageZeroUntilPitch(advancedClimber, arms, desiredPitchAngleStageZero, stabilizerPosition),
                new MoveNow(advancedClimber, arms, desiredPitchAngleStageZero),
//                new MoveArmsUntilOnPosition(advancedClimber, arms, desiredArmsSpeed, desiredArmsDelta),
                new ClimbWithStabilizersAndArmsStageTwoUntilPitch(advancedClimber, desiredPitchAngleStageTwo),
                new KeepPowerStabilizer(advancedClimber,keepStabilizerSpeed, buttonProvider),
                new EveryoneClaps(vision));
    }
}
