package frc.robot.providers;

import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;

public class AngleVisionProvider implements DoubleSupplier {

    private final Vision vision;
    private double lastAngle;

    public AngleVisionProvider(Vision vision) {
        this.vision = vision;
    }

    @Override
    public double getAsDouble() {
        if (vision.hasTarget()){
            lastAngle = -vision.getHorizontalAngleTurretToTargetRTT();
        }
        return lastAngle;
    }
}
