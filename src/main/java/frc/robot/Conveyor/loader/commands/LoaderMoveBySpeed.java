package frc.robot.Conveyor.loader.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Conveyor.loader.Loader;
import java.util.function.DoubleSupplier;

public class LoaderMoveBySpeed extends CommandBase {

    private final Loader conveyor;
    private final DoubleSupplier doubleSupplier;

    public LoaderMoveBySpeed(Loader conveyor, DoubleSupplier doubleSupplier) {
        this.conveyor = conveyor;
        this.doubleSupplier = doubleSupplier;
        addRequirements(conveyor);
    }

    @Override
    public void execute() {
        conveyor.moveLoaderBySpeed(doubleSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        conveyor.stop();
    }
}
