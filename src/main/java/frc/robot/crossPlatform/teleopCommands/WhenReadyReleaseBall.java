package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.MoveConveyor;
import frc.robot.conveyor.loader.Loader;

import java.util.function.BooleanSupplier;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.BALL_TRIGGER_SPEED;
import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.LOADER_SPEED;

public class WhenReadyReleaseBall extends SequentialCommandGroup {

    public WhenReadyReleaseBall(BooleanSupplier conditions, Loader loader, BallTrigger ballTrigger) {
        super(new WaitUntilReadyToShoot(conditions),
                new MoveConveyor(loader, ballTrigger, () -> LOADER_SPEED, () -> BALL_TRIGGER_SPEED));
    }
}
