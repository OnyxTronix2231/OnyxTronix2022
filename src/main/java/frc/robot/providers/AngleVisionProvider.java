package frc.robot.providers;

import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;

public class AngleVisionProvider implements DoubleSupplier {

    private final Vision vision;

    public AngleVisionProvider(Vision vision) {
        this.vision = vision;
    }

    @Override
    public double getAsDouble() {
        return vision.hasTarget() ? -vision.getHorizontalAngleTurretToTargetRTT() : 0;
    }
}
