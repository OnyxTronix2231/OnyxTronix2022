package frc.robot.conveyor.loader.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.conveyor.loader.Loader;

import java.util.function.DoubleSupplier;

public class LoadUntilBallIInPlace extends ParallelDeadlineGroup {

    public LoadUntilBallIInPlace(Loader loader, DoubleSupplier speedSupplier) {
        super(new WaitUntilCommand(loader::identifiedBall), new MoveLoaderBySpeed(loader, speedSupplier));
    }
}
