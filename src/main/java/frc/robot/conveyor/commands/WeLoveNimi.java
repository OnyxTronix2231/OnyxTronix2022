package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.conveyor.Conveyor;

import java.util.function.DoubleSupplier;

public class WeLoveNimi extends CommandBase {

    private final Conveyor conveyor;
    private final DoubleSupplier susyBalls; //The balls that are being stuck.

    public WeLoveNimi(Conveyor conveyor, DoubleSupplier susyBalls) {
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
