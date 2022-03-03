package frc.robot.conveyor.ballTrigger.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.conveyor.ballTrigger.BallTrigger;

import java.util.function.DoubleSupplier;

public class MoveBallTriggerBySpeed extends CommandBase {

    private final BallTrigger ballTrigger;
    private final DoubleSupplier speedSupplier;

    public MoveBallTriggerBySpeed(BallTrigger ballTrigger, DoubleSupplier speedSupplier) {
        this.ballTrigger = ballTrigger;
        this.speedSupplier = speedSupplier;
        addRequirements(ballTrigger);
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
