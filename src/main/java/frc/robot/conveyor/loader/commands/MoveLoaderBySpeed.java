package frc.robot.conveyor.loader.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.conveyor.loader.Loader;
import java.util.function.DoubleSupplier;

public class MoveLoaderBySpeed extends CommandBase {

    private final Loader loader;
    private final DoubleSupplier doubleSupplier;

    public MoveLoaderBySpeed(Loader loader, DoubleSupplier doubleSupplier) {
        this.loader = loader;
        this.doubleSupplier = doubleSupplier;
        addRequirements(loader);
    }

    @Override
    public void execute() {
        loader.moveLoaderBySpeed(doubleSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        loader.stop();
    }
}
