package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

public class Shooter extends SubsystemBase {

    private ShooterComponents shooterComponents;

    public Shooter(ShooterComponents shooterComponents){
        this.shooterComponents = shooterComponents;
    }

    public void setSpeed(double speed){
        shooterComponents.getMasterMotor().set(speed);
    }

    public void stop(){
        setSpeed(0);
    }

}
