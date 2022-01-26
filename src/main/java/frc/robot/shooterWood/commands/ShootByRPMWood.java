package frc.robot.shooterWood.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.shooterWood.ShooterWood;

import java.util.function.DoubleSupplier;

public class ShootByRPMWood extends CommandBase {

    private ShooterWood shooterWood;
    private DoubleSupplier rpm;

    public ShootByRPMWood(ShooterWood shooterWood, DoubleSupplier rpm) {
        this.shooterWood = shooterWood;
        this.rpm = rpm;
    }
    public void initialize(){
        shooterWood.initMoveByRPM(rpm.getAsDouble());
    }

    public void execute(){
        shooterWood.updateMoveByRPM(rpm.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        shooterWood.stop();
    }
}
