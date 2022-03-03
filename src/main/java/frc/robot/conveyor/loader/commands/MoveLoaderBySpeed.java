package frc.robot.conveyor.loader.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.conveyor.loader.Loader;

import java.util.function.DoubleSupplier;

public class MoveLoaderBySpeed extends CommandBase {

    private final Loader loader;
    private final DoubleSupplier speedSupplier;

    public MoveLoaderBySpeed(Loader loader, DoubleSupplier speedSupplier) {
        this.loader = loader;
        this.speedSupplier = speedSupplier;
        addRequirements(loader);
    }

    @Override
    public void execute() {
        loader.moveLoaderBySpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        loader.stop();
    }
}
