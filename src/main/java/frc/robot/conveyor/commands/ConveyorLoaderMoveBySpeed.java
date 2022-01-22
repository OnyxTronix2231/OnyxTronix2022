package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.conveyor.Conveyor;
import frc.robot.conveyor.Loader.Loader;

import java.util.function.DoubleSupplier;

public class ConveyorLoaderMoveBySpeed extends CommandBase {

    private final Loader loader;
    private final DoubleSupplier doubleSupplier;

    public ConveyorLoaderMoveBySpeed(Loader loader,DoubleSupplier doubleSupplier) {
        this.loader = loader;
        this.doubleSupplier = doubleSupplier;
        addRequirements(this.loader);
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
