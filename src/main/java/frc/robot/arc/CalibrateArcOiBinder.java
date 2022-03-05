package frc.robot.arc;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.commands.CalibrateArc;

import static frc.robot.Constants.ARC_CALIBRATION_SPEED;

public class CalibrateArcOiBinder {

    public CalibrateArcOiBinder(Arc arc, Trigger calibrateAngle) {
        calibrateAngle.whenActive(new CalibrateArc(arc, () -> ARC_CALIBRATION_SPEED));
    }
}
