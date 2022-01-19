package frc.robot.ShooterWood.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ShooterWood.ShooterWood;

public class ShootByRPMWood extends CommandBase {

    private ShooterWood shooterWood;
    private double speed;

    public ShootByRPMWood(ShooterWood shooterWood, double speed) {
        this.shooterWood = shooterWood;
        this.speed = speed;
    }
    public void initialize(){
        shooterWood.initMoveByRPM(speed);
    }

    public void execute(){
        shooterWood.updateMoveByRPM(speed);
    }

    @Override
    public void end(boolean interrupted) {
        shooterWood.stop();
    }
}
