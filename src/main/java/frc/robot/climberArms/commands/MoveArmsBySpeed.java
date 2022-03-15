package frc.robot.climberArms.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climberArms.ClimberArms;

import java.util.function.DoubleSupplier;

public class MoveArmsBySpeed extends CommandBase {

    private final ClimberArms climber;
    private final DoubleSupplier speedSupplier;

    public MoveArmsBySpeed(ClimberArms climber, DoubleSupplier speedSupplier) {
        this.climber = climber;
        this.speedSupplier = speedSupplier;
        addRequirements(climber);
    }

    @Override
    public void execute() {
        climber.moveArmsBySpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        climber.stopArms();
    }
}
