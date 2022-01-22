package frc.robot.conveyor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.conveyor.ConveyorConstants.*;

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
    public boolean isStuck() {
        return components.getLoaderMotor().getSupplyCurrent() > NORMAL_AMP;
        //in one side is geting amper and other is checking amper he he ha ha yeahhhhhhh
    }
}
