package frc.robot.yawControl;

import frc.robot.yawControl.Commands.RotateToAngleRTF;

import java.util.function.DoubleSupplier;

public class DriverYawControlOiBinder {

    public DriverYawControlOiBinder(YawControl yawControl, DoubleSupplier angleSupplier) {
        yawControl.setDefaultCommand(new RotateToAngleRTF(yawControl, angleSupplier));
    }
}
