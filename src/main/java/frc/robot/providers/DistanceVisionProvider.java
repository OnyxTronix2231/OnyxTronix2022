package frc.robot.providers;

import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;

public class DistanceVisionProvider implements DoubleSupplier {

    private final Vision vision;

    public DistanceVisionProvider(Vision vision) {
        this.vision = vision;
    }

    @Override
    public double getAsDouble() {
        return vision.hasTarget() ? vision.getHorizontalDistanceTurretToTarget() : 0;
    }
}
