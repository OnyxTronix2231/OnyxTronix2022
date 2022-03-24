package frc.robot.arms.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arms.Arms;

import java.util.function.DoubleSupplier;

public class MoveArmsBySpeed extends CommandBase {

    private final Arms arms;
    private final DoubleSupplier speedSupplier;

    public MoveArmsBySpeed(Arms arms, DoubleSupplier speedSupplier) {
        this.arms = arms;
        this.speedSupplier = speedSupplier;
        addRequirements(arms);
    }

    @Override
    public void execute() {
        arms.moveArmsBySpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        arms.stopArms();
    }
}
