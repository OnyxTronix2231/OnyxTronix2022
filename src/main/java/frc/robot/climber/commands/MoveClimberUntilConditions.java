package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.climber.Climber;
import sensors.Switch.Microswitch;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class MoveClimberUntilConditions extends ParallelDeadlineGroup {
    public MoveClimberUntilConditions(Climber climber, DoubleSupplier speedSupplier, BooleanSupplier isMicroSwitchOpen) {
        super(new ClimbConditions(isMicroSwitchOpen), new MoveClimberBySpeed(climber, speedSupplier));
    }
}
