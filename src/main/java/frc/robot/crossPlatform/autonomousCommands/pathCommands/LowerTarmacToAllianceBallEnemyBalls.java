package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.commands.MoveByPath;

import static frc.robot.drivetrain.DriveTrainConstants.Paths.PATH_E_ENEMY_BALL;
import static frc.robot.drivetrain.DriveTrainConstants.Paths.PATH_E_FIRST_BALL;

public class LowerTarmacToAllianceBallEnemyBalls extends SequentialCommandGroup {

    public LowerTarmacToAllianceBallEnemyBalls(DriveTrain driveTrain) {
        super(
                new MoveByPath(driveTrain, PATH_E_FIRST_BALL),
                // TODO: collecting the ball
                // TODO: shooting 2 balls
                new MoveByPath(driveTrain, PATH_E_ENEMY_BALL)
                // TODO: collecting the enemy ball
                // TODO: shooting away the enemy ball
        );
    }
}
