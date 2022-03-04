package frc.robot.yawControl;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.yawControl.Commands.RotateToAngleRTF;

import static frc.robot.turret.TurretConstants.*;

public class DriverYawControlOiBinder {

    public DriverYawControlOiBinder(YawControl yawControl, Trigger rotateAngleRTF) {
        rotateAngleRTF.whileActiveContinuous(new RotateToAngleRTF(yawControl, ()-> 30));
    }
}
