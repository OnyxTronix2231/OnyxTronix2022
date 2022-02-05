package frc.robot.trigger.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.trigger.BallTrigger;

import java.util.function.DoubleSupplier;

public class TriggerMoveBySpeed extends CommandBase {

    private final BallTrigger trigger;
    private final DoubleSupplier doubleSupplier;

    @Override
    public void initialize() {
        trigger.stop();
    }

    @Override
    public boolean isFinished() {
        return trigger.isLoadedV2();
    }

    public TriggerMoveBySpeed(BallTrigger trigger, DoubleSupplier doubleSupplier) {
        this.trigger = trigger;
        this.doubleSupplier = doubleSupplier;
        addRequirements(trigger);
    }

    @Override
    public void execute() {
        trigger.moveTriggerBySpeed(doubleSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        trigger.stop();
    }
}
