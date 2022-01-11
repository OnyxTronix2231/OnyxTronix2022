package frc.robot.turret.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.turret.Turret;

import java.util.function.DoubleSupplier;

public class MoveBySpeed extends CommandBase {
    private Turret turret;
    private DoubleSupplier speed;

    public MoveBySpeed(Turret turret, DoubleSupplier speed) {
        this.turret = turret;
        this.speed = speed;
    }

    @Override
    public void execute() {
        turret.setspeed(speed.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        turret.stop();
    }
}
