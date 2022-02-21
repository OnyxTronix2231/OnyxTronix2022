package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriveTrainConstants;
import frc.robot.drivetrain.commands.MoveByPath;
import frc.robot.drivetrain.commands.ResetOdometryToPose;

import static frc.robot.drivetrain.DriveTrainConstants.Paths.*;

public class UpperTarmacTo5AllianceBalls extends SequentialCommandGroup {

    public UpperTarmacTo5AllianceBalls(DriveTrain driveTrain) {
        super(
                new ResetOdometryToPose(driveTrain, DriveTrainConstants.StartPoses.S1),
                new MoveByPath(driveTrain, PATH_A_FIRST_BALL),
                // TODO: collect ball at point
                // TODO: shoots 2 balls from the point
                new MoveByPath(driveTrain, PATH_A_SECOND_BALL),
                // TODO: collect the ball
                new MoveByPath(driveTrain, PATH_A_THIRD_BALL),
                // TODO: collect the ball
                new MoveByPath(driveTrain, PATH_A_SHOOTING_PLACE),
                // TODO: at point shooting 2 balls
                new MoveByPath(driveTrain, PATH_A_FOURTH_BALL),
                // TODO: collecting the ball
                // TODO: shooting the ball
                new MoveByPath(driveTrain, PATH_A_ENEMY_BALL)
                // TODO: collecting the enemy ball and shooting it away
        );
    }
}
