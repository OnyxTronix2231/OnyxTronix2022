package frc.robot.conveyor.ballTrigger.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import java.util.function.DoubleSupplier;

public class TriggerMoveBySpeed extends CommandBase {

    private final BallTrigger ballTrigger;
    private final DoubleSupplier speedSupplier;

    public TriggerMoveBySpeed(BallTrigger ballTrigger, DoubleSupplier doubleSupplier) {
        this.ballTrigger = ballTrigger;
        this.speedSupplier = doubleSupplier;
        addRequirements(ballTrigger);
    }

    @Override
    public void initialize() {
        ballTrigger.stop();
    }

    @Override
    public void execute() {
        ballTrigger.moveTriggerBySpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        ballTrigger.stop();
    }
}
