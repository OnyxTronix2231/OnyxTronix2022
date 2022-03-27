package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RGB.logicCommands.RGB_Shooting;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.MoveConveyor;
import frc.robot.conveyor.loader.Loader;

import java.util.function.BooleanSupplier;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.BALL_TRIGGER_SPEED;
import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.LOADER_SPEED;

public class WhenSubsystemsReadyReleaseBall extends SequentialCommandGroup {

    public WhenSubsystemsReadyReleaseBall(BooleanSupplier conditions, Loader loader, BallTrigger ballTrigger) {
        super(new WaitUntilReadyToShoot(conditions),
                new ParallelCommandGroup(
                new MoveConveyor(loader, ballTrigger, () -> LOADER_SPEED, () -> BALL_TRIGGER_SPEED),
                new RGB_Shooting()));
    }
}
