package frc.robot.loader.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.loader.Loader;

import java.util.function.DoubleSupplier;

public class WeLoveNimi extends CommandBase {

    private final Loader conveyor;
    private final DoubleSupplier susyBalls; //The balls that are being stuck.

    public WeLoveNimi(Loader conveyor, DoubleSupplier susyBalls) {
        this.conveyor = conveyor;
        this.susyBalls = susyBalls;
        addRequirements(conveyor);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

}
