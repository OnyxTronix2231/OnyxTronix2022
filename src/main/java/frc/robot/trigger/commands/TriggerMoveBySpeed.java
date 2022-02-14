package frc.robot.trigger.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.trigger.BallTrigger;
import java.util.function.DoubleSupplier;

public class TriggerMoveBySpeed extends CommandBase {

    private final BallTrigger trigger;
    private final DoubleSupplier speedSupplier;

    public TriggerMoveBySpeed(BallTrigger trigger, DoubleSupplier doubleSupplier) {
        this.trigger = trigger;
        this.speedSupplier = doubleSupplier;
        addRequirements(trigger);
    }

    @Override
    public void initialize() {
        trigger.stop();
    }

    @Override
    public void execute() {
        trigger.moveTriggerBySpeed(speedSupplier.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        return trigger.isLoadedV3();
    }

    @Override
    public void end(boolean interrupted) {
        trigger.stop();
    }
}
