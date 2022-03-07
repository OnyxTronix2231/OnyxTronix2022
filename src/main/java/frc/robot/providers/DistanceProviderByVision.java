package frc.robot.providers;

import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;

public class DistanceProviderByVision implements DistanceProvider {

    private final Vision vision;
    private double lastDistance;

    public DistanceProviderByVision(Vision vision) {
        this.vision = vision;
    }

    @Override
    public double getAsDouble() {
        if (vision.hasTarget()) {

            lastDistance = vision.getHorizontalDistanceTurretToTarget();
            if (lastDistance >= 580) {
                lastDistance += 20;
            }
            lastDistance += 20;

        }
        return lastDistance;
    }
}
