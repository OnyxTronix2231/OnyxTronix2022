package frc.robot.providers;

import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;

public class AngleProviderByVision implements AngleProvider {

    public AngleProviderByVision() {
    }

    @Override
    public double getAsDouble() {
        return -Vision.getInstance().getHorizontalAngleTurretToTargetRTT();
    }
}
