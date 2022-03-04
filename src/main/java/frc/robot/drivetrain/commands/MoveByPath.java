package frc.robot.drivetrain.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.Path;

import static frc.robot.drivetrain.DriveTrainConstants.DRIVE_KINEMATICS;
import static frc.robot.drivetrain.DriveTrainConstants.FEEDFORWARD;
import static frc.robot.drivetrain.commands.DriveTrainCommandConstants.*;

public class MoveByPath extends CommandBase {

    private final DriveTrain driveTrain;
    private final Path currentPath;
    private Trajectory trajectory;
    private RamseteCommand command;

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
                new PIDController(TRAJECTORY_P, TRAJECTORY_I, TRAJECTORY_D),
                new PIDController(TRAJECTORY_P, TRAJECTORY_I, TRAJECTORY_D),
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
