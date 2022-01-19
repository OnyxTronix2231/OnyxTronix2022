package frc.robot.ShooterWood.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ShooterWood.Shooter;

public class ShootByRPM extends CommandBase {

    private Shooter shooter;
    private double speed;

    public ShootByRPM(Shooter shooter, double speed) {
        this.shooter = shooter;
        this.speed = speed;
    }
    public void initialize(){
        shooter.initMoveByRPM(speed);
    }

    public void execute(){
        shooter.updateMoveByRPM(speed);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }
}
