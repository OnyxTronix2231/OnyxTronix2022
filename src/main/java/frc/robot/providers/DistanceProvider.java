package frc.robot.providers;

import frc.robot.drivetrain.DriveTrain;
import frc.robot.vision.Vision;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class DistanceProvider implements DoubleSupplier {

    private final DriveTrain driveTrain;
    private final Vision vision;

    public DistanceProvider(DriveTrain driveTrain, Vision vision) {
        this.driveTrain = driveTrain;
        this.vision = vision;
    }

    @Override
    public double getAsDouble() {
        return vision.hasTarget() ? vision.getHorizontalDistanceTurretToTarget()
                : driveTrain.getDistanceFromTargetByEncoders();
    }
}
