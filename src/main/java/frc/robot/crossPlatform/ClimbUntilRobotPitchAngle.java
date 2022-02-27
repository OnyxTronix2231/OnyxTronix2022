package frc.robot.crossPlatform;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.climber.Climber;
import frc.robot.climber.commands.ClimbBySpeed;
import frc.robot.drivetrain.DriveTrain;

import java.util.function.DoubleSupplier;

public class ClimbUntilRobotPitchAngle extends ParallelDeadlineGroup {

    public ClimbUntilRobotPitchAngle(Climber climber, DriveTrain driveTrain, DoubleSupplier speedSupplier) {
        super(new WaitUntilRobotPitchAngle(climber, driveTrain), new ClimbBySpeed(climber, speedSupplier));
    }
}
