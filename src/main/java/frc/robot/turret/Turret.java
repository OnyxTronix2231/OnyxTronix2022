package frc.robot.turret;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
    private TurretComponents turretComponents;

    public Turret(TurretComponents turretComponents) {this.turretComponents = turretComponents;}

    public void setspeed(double speed) {
        turretComponents.getMasterMotor().set(speed);
    }

    public void stop(){
        setspeed(0);
    }
}
