package frc.robot.loader.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.loader.Loader;

import java.util.function.DoubleSupplier;

public class LoadUntilBallIdentified extends ParallelDeadlineGroup {
    public LoadUntilBallIdentified(Loader loader, DoubleSupplier speedSupplier) {
        super(new WaitUntilCommand(loader::identifiedBall), new LoaderMoveBySpeed(loader, speedSupplier));
    }
}
