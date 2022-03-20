package frc.robot.providers;

import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;

public class AngleProviderByVision implements AngleProvider {

    private final Vision vision;

    public AngleProviderByVision(Vision vision) {
        this.vision = vision;
    }

    @Override
    public double getAsDouble() {
        return -vision.getHorizontalAngleTurretToTargetRTT();
    }
}
