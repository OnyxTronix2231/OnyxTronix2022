package frc.robot.Conveyor.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Conveyor.Conveyor;

import java.util.function.DoubleSupplier;

public class ConveyorTriggerMoveBySpeed extends CommandBase {
    
    private  Conveyor conveyor;
    private  DoubleSupplier doubleSupplier;

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        conveyor.triggerBySpeed(doubleSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        conveyor.stop();
    }
}
