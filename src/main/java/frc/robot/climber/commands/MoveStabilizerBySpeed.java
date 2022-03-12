package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;

public class MoveStabilizerBySpeed extends CommandBase {
    private final Climber climber;
    private final DoubleSupplier speedSupplier;

    public MoveStabilizerBySpeed(Climber climber, DoubleSupplier speedSupplier) {
        this.climber = climber;
        this.speedSupplier = speedSupplier;
    }

    @Override
    public void execute() {
        climber.moveStabilizerMotorBySpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        climber.stopStabilizer();
    }
}
