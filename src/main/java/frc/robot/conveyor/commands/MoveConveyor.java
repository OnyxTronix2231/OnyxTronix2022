package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;

import java.util.function.DoubleSupplier;

public class MoveConveyor extends ParallelCommandGroup {

    public MoveConveyor(Loader loader, BallTrigger ballTrigger, DoubleSupplier loadSpeed,
                        DoubleSupplier ballTriggerSpeed) {
        super(
                new MoveBallTriggerBySpeed(ballTrigger, ballTriggerSpeed),
                new WaitCommand(0.3).andThen(
                new MoveLoaderBySpeed(loader, loadSpeed))
        );
    }
}
