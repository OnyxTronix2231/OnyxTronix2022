package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.conveyor.Conveyor;

import java.util.function.DoubleSupplier;

public class ConveyorLoaderMoveBySpeed extends CommandBase {

    private final Conveyor conveyor;
    private final DoubleSupplier doubleSupplier;

    public ConveyorLoaderMoveBySpeed(Conveyor conveyor, DoubleSupplier doubleSupplier) {
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
