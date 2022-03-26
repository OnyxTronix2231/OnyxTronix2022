package frc.robot.advancedClimber;

import frc.robot.arms.Arms;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.stabilizers.Stabilizer;
import frc.robot.stabilizers.StabilizerComponents;
import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;

import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_ROLL_ANGLE;

public class AdvancedClimber extends Stabilizer {

    private final DriveTrain driveTrain;
    private int stage = 0;
    private double pitchOffset;
    private boolean firstCalibrate = true;

    public AdvancedClimber(StabilizerComponents components, DriveTrain driveTrain, Arms arms, Vision vision
    ,DoubleSupplier desiredPitch) {
        super(components);
        this.driveTrain = driveTrain;
        new AdvancedClimberShuffleBoard(this, arms, vision, desiredPitch);
    }

    public void calibratePitch() {
        if(firstCalibrate) {
            pitchOffset = getCurrentPitch();
            firstCalibrate = false;
        }
    }

    public double getPitchWithOffset() {
        return getCurrentPitch() - Math.abs(pitchOffset);
    }

    public boolean isOnDesiredRollAngle() {
        return driveTrain.getRoll() >= DESIRED_ROLL_ANGLE;
    }

    public boolean isOnDesiredPitchAngle(double angle) {
        return getPitchWithOffset() >= angle;
    }

    public boolean isOnDesiredPitchAngleStageTwo(double angle) {
        return getPitchWithOffset() <= angle;
    }

    public double getCurrentPitch() {
        return driveTrain.getPitch();
    }

    public double getCurrentRoll() {
        return driveTrain.getRoll();
    }

    public double getCurrentYaw() {
        return driveTrain.getHeading();
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
}
