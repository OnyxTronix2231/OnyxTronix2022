package frc.robot.drivetrain.commands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.commands.MoveByPath;

import static frc.robot.drivetrain.DriveTrainConstants.Paths.*;

public class SecondPathOption extends SequentialCommandGroup {
    public SecondPathOption(DriveTrain driveTrain) {
        super(
                new MoveByPath(driveTrain, PATH_A_FIRST_BALL),
                // shoot
                new MoveByPath(driveTrain, PATH_B_SECOND_BALL)
        );
    }
}