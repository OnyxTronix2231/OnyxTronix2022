package frc.robot.providers;

import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;

public class DistanceVisionProvider implements DoubleSupplier {

    private final Vision vision;
    private double lastDistance;

    public DistanceVisionProvider(Vision vision) {
        this.vision = vision;
    }

    @Override
    public double getAsDouble() {
        if (vision.hasTarget()) {
            lastDistance = vision.getHorizontalDistanceTurretToTarget();
        }
        return lastDistance;
    }
}
