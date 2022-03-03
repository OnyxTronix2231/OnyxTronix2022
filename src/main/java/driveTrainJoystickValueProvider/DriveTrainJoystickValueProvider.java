package driveTrainJoystickValueProvider;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.drivetrain.DriveTrain;

import static driveTrainJoystickValueProvider.driveTrainJoystickValueProviderConstants.DEADBAND;

public class DriveTrainJoystickValueProvider extends SubsystemBase {

    private final DriveTrain driveTrain;
    private boolean isForward;

    public DriveTrainJoystickValueProvider(DriveTrain driveTrain) {
        this.driveTrain = driveTrain;
    }

    @Override
    public void periodic() {
        double speed = driveTrain.getForwardSpeedValue();
        isForward = Math.abs(speed) > DEADBAND ? speed > DEADBAND : isForward;
    }

    public boolean isForward(){
        return isForward;
    }
}
