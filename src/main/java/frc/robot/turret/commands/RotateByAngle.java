package frc.robot.turret.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.turret.Turret;
import java.util.function.DoubleSupplier;

public class RotateByAngle extends CommandBase {

    protected DoubleSupplier angleSupplier;
    protected Turret turret;
    protected RotateToAngleRTR rotateToAngleRTR;

    public RotateByAngle(Turret turret, DoubleSupplier angleSupplier) {
       this.turret = turret;
       this.angleSupplier = angleSupplier;
       this.rotateToAngleRTR = null;
    }

    @Override
    public void initialize() {
        double dest = angleSupplier.getAsDouble() + turret.getCurrentAngleRTR();
        rotateToAngleRTR = new RotateToAngleRTR(turret, () -> dest);
        rotateToAngleRTR.initialize();
    }

    @Override
    public void execute() {
        rotateToAngleRTR.execute();
    }

    @Override
    public boolean isFinished() {
        return rotateToAngleRTR.isFinished();
    }

    @Override
    public void end(boolean interrupted) {
        rotateToAngleRTR.end(interrupted);
    }
}
