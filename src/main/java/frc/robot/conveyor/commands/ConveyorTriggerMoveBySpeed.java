package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.conveyor.Conveyor;

import java.util.function.DoubleSupplier;

public class ConveyorTriggerMoveBySpeed extends CommandBase {

    private final Conveyor conveyor;
    private final DoubleSupplier doubleSupplier;

    public ConveyorTriggerMoveBySpeed(Conveyor conveyor, DoubleSupplier doubleSupplier) {
        this.conveyor = conveyor;
        this.doubleSupplier = doubleSupplier;
        addRequirements(conveyor);
    }

    @Override
    public void execute() {
        conveyor.moveTriggerBySpeed(doubleSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        conveyor.stop();
    }
}
