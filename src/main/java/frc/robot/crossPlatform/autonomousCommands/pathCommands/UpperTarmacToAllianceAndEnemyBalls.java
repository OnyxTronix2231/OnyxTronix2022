package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.commands.MoveByPath;

import static frc.robot.crossPlatform.autonomousCommands.pathCommands.PathCommandsConstants.Paths.*;

public class UpperTarmacToAllianceAndEnemyBalls extends SequentialCommandGroup {

    public UpperTarmacToAllianceAndEnemyBalls(DriveTrain driveTrain) {
        super(
                new MoveByPath(driveTrain, PATH_C_FIRST_BALL),
                // TODO: collecting the ball
                // TODO: shooting 2 balls
                new MoveByPath(driveTrain, PATH_C_ENEMY_BALL)
                // TODO: collecting enemy ball& shooting it away
        );
    }
}
