package frc.robot.Conveyor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Conveyor extends SubsystemBase {
    private  ConveyorComponents components;

    public Conveyor(ConveyorComponents components) {
        this.components = components;
    }

    public void triggerBySpeed(double speed){
        components.getTriggerMotor().set(speed);
    }
    public void floorBySpeed(double speed){
        components.getFloorMotor().set(speed);
    }
    public void stop(){
        triggerBySpeed(0);
        floorBySpeed(0);
    }

}
