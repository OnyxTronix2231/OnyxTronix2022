package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.conveyor.Conveyor;

import java.util.function.DoubleSupplier;

public class MoveTwoMotors extends ParallelCommandGroup {
    public MoveTwoMotors(Conveyor conveyor, DoubleSupplier speedSupplier) {
        super(
            new ConveyorTriggerMoveBySpeed(conveyor, speedSupplier),
                new ConveyorLoaderMoveBySpeed(conveyor, speedSupplier)
        );
    }
}
