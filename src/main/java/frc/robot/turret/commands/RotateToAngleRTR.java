package frc.robot.turret.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.turret.Turret;
import java.util.function.DoubleSupplier;

public class RotateToAngleRTR extends CommandBase {

    protected final Turret turret;
    protected final DoubleSupplier angleSupplier;

    public RotateToAngleRTR(Turret turret, DoubleSupplier angleSupplier) {
        this.turret = turret;
        this.angleSupplier = angleSupplier;
        addRequirements(turret);
    }

    @Override
    public void initialize() {
        turret.initMoveToDegreeRTR(angleSupplier.getAsDouble());
    }

    @Override
    public void execute() {
        turret.updateMoveToDegreeRTR(angleSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("ENDDD");
        turret.stop();
    }
}
