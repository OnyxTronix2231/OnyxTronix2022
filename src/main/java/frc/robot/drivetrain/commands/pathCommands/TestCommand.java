package frc.robot.drivetrain.commands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.commands.MoveByPath;

import static frc.robot.drivetrain.DriveTrainConstants.Paths.*;

public class TestCommand extends SequentialCommandGroup {

    public TestCommand(DriveTrain driveTrain) {
        super(new MoveByPath(driveTrain, DRIVE_TO_FIRST_BALL),
                // shoot
                new MoveByPath(driveTrain, DRIVE_TO_SECOND_BALL),
                new MoveByPath(driveTrain, DRIVE_TO_THIRD_BALL),
                // shoot
                new MoveByPath(driveTrain, path4),
                new MoveByPath(driveTrain, path5),
                // shoot
                new MoveByPath(driveTrain, path6),
                // kick
                new MoveByPath(driveTrain, path7)
                // kick
        );
    }
}
