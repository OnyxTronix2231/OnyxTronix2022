package frc.robot.yawControl;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.turret.commands.RotateBySpeed;
import frc.robot.turret.commands.RotateToAngleRTR;
import frc.robot.vision.Vision;
import frc.robot.yawControl.Commands.RotateToAngleRTF;

import static frc.robot.turret.TurretConstants.DEFAULT_TURRET_SPEED;
import static frc.robot.turret.TurretConstants.MIDDLE_ANGLE;

public class DriverYawControlOiBinder {

    public DriverYawControlOiBinder(YawControl yawControl, Trigger rotateByPose, Trigger moveLeft, Trigger moveRight, Vision vision) {
        rotateByPose.whileActiveContinuous(new RotateToAngleRTR(yawControl, yawControl::getAngleRTRToTarget));
        moveLeft.whileActiveContinuous(new RotateBySpeed(yawControl, () -> DEFAULT_TURRET_SPEED));
        moveRight.whileActiveContinuous(new RotateBySpeed(yawControl, () -> -DEFAULT_TURRET_SPEED));
    }
}
