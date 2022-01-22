package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.conveyor.Trigger.ConveyorTriggerMoveBySpeed;

import java.util.function.DoubleSupplier;

public class MoveTwoMotors extends ParallelCommandGroup {
    public MoveTwoMotors(ConveyorTriggerMoveBySpeed.Trigger trigger, DoubleSupplier speedSupplier) {
        super(
            new ConveyorTriggerMoveBySpeed(trigger, speedSupplier),
                new ConveyorLoaderMoveBySpeed(Loader, speedSupplier)
        );
    }
}
