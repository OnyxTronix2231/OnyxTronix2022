package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.commands.MoveByPath;
import frc.robot.drivetrain.commands.ResetOdometryToPose;

import static frc.robot.drivetrain.DriveTrainConstants.Paths.*;
import static frc.robot.drivetrain.DriveTrainConstants.startPoses.S1;

public class UpperTarmacTo5AllianceBalls extends SequentialCommandGroup {
    public UpperTarmacTo5AllianceBalls(DriveTrain driveTrain){
        super(
                new ResetOdometryToPose(driveTrain, S1),
                new MoveByPath(driveTrain, PATH_A_FIRST_BALL),
                //collect ball at point
                // shoots 2 balls from the point
                new MoveByPath(driveTrain, PATH_A_SECOND_BALL),
                //collect the ball
                new MoveByPath(driveTrain, PATH_A_THIRD_BALL),
                //collect the ball
                new MoveByPath(driveTrain, PATH_A_SHOOTING_PLACE),
                //at point shooting 2 balls
                new MoveByPath(driveTrain,PATH_A_FOURTH_BALL),
                //collecting the ball
                // shooting the ball
                new MoveByPath(driveTrain,PATH_A_ENEMY_BALL)
                //collecting the enemy ball and shooting it away
        );
    }
}
