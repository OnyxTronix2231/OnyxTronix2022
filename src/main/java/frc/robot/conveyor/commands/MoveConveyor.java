package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

import java.util.function.DoubleSupplier;

public class MoveConveyor extends ParallelCommandGroup {

    public MoveConveyor(Loader loader, BallTrigger ballTrigger, DoubleSupplier loadSpeed,
                        DoubleSupplier ballTriggerSpeed) {
        super(
                new MoveLoaderBySpeed(loader, loadSpeed),
                new MoveBallTriggerBySpeed(ballTrigger, ballTriggerSpeed)
        );
    }
}
