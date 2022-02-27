package frc.robot.crossPlatform;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.Climber;
import frc.robot.drivetrain.DriveTrain;

import static frc.robot.crossPlatform.CrossPlatformConstants.*;

public class CrossPlatformDriverOiBinder {

    public CrossPlatformDriverOiBinder(Climber climber, DriveTrain driveTrain, Trigger climbUntilPosition) {
        climbUntilPosition.whileActiveOnce(new ClimbUntilRobotPitchAngle(climber, driveTrain, ()->CLIMB_SPEED));
    }
}
