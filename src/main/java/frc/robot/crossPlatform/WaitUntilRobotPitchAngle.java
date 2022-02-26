package frc.robot.crossPlatform;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climber.Climber;
import frc.robot.drivetrain.DriveTrain;

import static frc.robot.crossPlatform.CrossPlatformConstants.*;

public class WaitUntilRobotPitchAngle extends CommandBase {

    private final Climber climber;
    private final DriveTrain driveTrain;

    public WaitUntilRobotPitchAngle(Climber climber, DriveTrain driveTrain) {
        this.climber = climber;
        this.driveTrain = driveTrain;
        addRequirements(climber);
    }

    @Override
    public void execute() {
        climber.moveBySpeed(0.8);
    }

    @Override
    public boolean isFinished() {
        return driveTrain.getPitch() == CLIMB_ANGLE;
    }

    @Override
    public void end(boolean interrupted) {
        climber.stopMotors();
    }
}
