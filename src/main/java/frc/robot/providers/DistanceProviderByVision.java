package frc.robot.providers;

import frc.robot.vision.Vision;

public class DistanceProviderByVision implements DistanceProvider {

    private final Vision vision;

    public DistanceProviderByVision(Vision vision) {
        this.vision = vision;
    }

    @Override
    public double getAsDouble() {
        return vision.getHorizontalDistanceTurretToTarget();
    }
}
