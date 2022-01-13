package frc.robot.conveyor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Conveyor extends SubsystemBase {

    private final ConveyorComponents components;

    public Conveyor(ConveyorComponents components) {
        this.components = components;
    }

    public void moveTriggerBySpeed(double speed) {
        components.getTriggerMotor().set(speed);
    }

    public void moveLoaderBySpeed(double speed) {
        components.getLoaderMotor().set(speed);
    }

    public void stop() {
        moveTriggerBySpeed(0);
        moveLoaderBySpeed(0);
    }
}
