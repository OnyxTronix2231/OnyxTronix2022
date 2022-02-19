package frc.robot.turret.commands;

import frc.robot.turret.Turret;

public class CalibrateTurret extends RotateBySpeed{

    public CalibrateTurret(Turret turret) {
        super(turret, ()-> 0.324);
    }

    @Override
    public boolean isFinished() {
        return turret.isCalibrated();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);

    }
}
