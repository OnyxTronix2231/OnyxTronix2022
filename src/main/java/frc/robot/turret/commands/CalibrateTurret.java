package frc.robot.turret.commands;

import frc.robot.turret.Turret;

import static frc.robot.turret.TurretConstants.*;

public class CalibrateTurret extends RotateBySpeed {

    public CalibrateTurret(Turret turret) {
        super(turret, () -> CALIBRATION_SPEED);
    }

    @Override
    public boolean isFinished() {
        return turret.isCalibrated();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        turret.activateSoftLimits();
    }
}
