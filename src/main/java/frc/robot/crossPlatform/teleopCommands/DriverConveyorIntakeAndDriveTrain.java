package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.*;

public class DriverConveyorIntakeAndDriveTrain {

    public DriverConveyorIntakeAndDriveTrain(DriveTrain driveTrain, Intake intakeFront, Intake intakeBack,
                                             Loader loader, BallTrigger ballTrigger, Trigger collect) {
        collect.whileActiveContinuous(new MoveIntakeAndConveyorByDriveTrain(driveTrain, intakeFront, intakeBack
                , loader, ballTrigger, () -> LOADER_SPEED, () -> BALL_TRIGGER_SPEED, () -> INTAKE_SPEED));
    }
}
