package frc.robot.conveyor.Trigger;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

public class ConveyorTriggerMoveBySpeed extends CommandBase {

    private final Trigger trigger;
    private final DoubleSupplier doubleSupplier;

    public ConveyorTriggerMoveBySpeed( Trigger trigger, DoubleSupplier doubleSupplier) {
        this.trigger = trigger;
        this.doubleSupplier = doubleSupplier;
        addRequirements(trigger);
    }



    @Override
    public void end(boolean interrupted) {
        trigger.stop();
    }


    public static class Trigger extends SubsystemBase {
        private final TriggerComponents components;

        public Trigger(TriggerComponents components) {
            this.components = components;
        }

        public void moveTriggerBySpeed(double speed) {
            components.getLoaderMotor().set(speed);
        }
        public void stop() {
            moveTriggerBySpeed(0);
            //moveLoaderBySpeed(0);
        }

        @Override
        public void execute() {
            components.moveTriggerBySpeed(doubleSupplier.getAsDouble());
        }
    }
}
