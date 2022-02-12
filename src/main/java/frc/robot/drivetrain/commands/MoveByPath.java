package frc.robot.drivetrain.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.Path;

import static frc.robot.drivetrain.DriveTrainConstants.*;

public class MoveByPath extends CommandBase {
    private DriveTrain driveTrain;
    private Trajectory trajectory;
    private RamseteCommand command;
    private Path currentPath;

    public MoveByPath(DriveTrain driveTrain, Path path) {
        this.driveTrain = driveTrain;
        currentPath = path;
        trajectory = currentPath.toTrajectory(driveTrain.getPose());
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        trajectory = currentPath.toTrajectory(driveTrain.getPose());
        command = new RamseteCommand(
                trajectory,
                driveTrain::getPose,
                new RamseteController(),
                FEEDFORWARD,
                DRIVE_KINEMATICS,
                driveTrain::getWheelSpeeds,
                new PIDController(TRAJECTORY_P, 0, 0),
                new PIDController(TRAJECTORY_P, 0, 0),
                driveTrain::tankDriveVolts,
                driveTrain
        );
        command.initialize();
    }

    @Override
    public void execute() {
        command.execute();
    }

    @Override
    public boolean isFinished() {
        return command.isFinished();
    }

    @Override
    public void end(boolean interrupted) {
        command.end(interrupted);
        driveTrain.stop();
    }
}