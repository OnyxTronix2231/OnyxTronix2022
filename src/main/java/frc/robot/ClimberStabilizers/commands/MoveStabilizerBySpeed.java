package frc.robot.ClimberStabilizers.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ClimberStabilizers.ClimberStabilizers;
import frc.robot.climberArms.ClimberArms;

import java.util.function.DoubleSupplier;

public class MoveStabilizerBySpeed extends CommandBase {

    private final ClimberStabilizers climberStabilizers;
    private final DoubleSupplier speedSupplier;

    public MoveStabilizerBySpeed(ClimberStabilizers climberStabilizers, DoubleSupplier speedSupplier) {
        this.climberStabilizers = climberStabilizers;
        this.speedSupplier = speedSupplier;
    }

    @Override
    public void execute() {
        climberStabilizers.moveStabilizerMotorBySpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        climberStabilizers.stopStabilizer();
    }
}
