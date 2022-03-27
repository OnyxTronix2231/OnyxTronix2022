package frc.robot.providers;

import frc.robot.vision.Vision;

public class DistanceProviderByVision implements DistanceProvider {

    public DistanceProviderByVision() {
    }

    @Override
    public double getAsDouble() {
        return Vision.getInstance().getHorizontalDistanceTurretToTarget();
    }
}
