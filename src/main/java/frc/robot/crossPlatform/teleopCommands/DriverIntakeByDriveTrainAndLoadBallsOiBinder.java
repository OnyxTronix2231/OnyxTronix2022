package frc.robot.crossPlatform.teleopCommands;

import driveTrainJoystickValueProvider.DriveTrainJoystickValueProvider;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.intake.Intake;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.*;

public class DriverIntakeByDriveTrainAndLoadBallsOiBinder {

    public DriverIntakeByDriveTrainAndLoadBallsOiBinder(DriveTrainJoystickValueProvider joystickValueProvider, Intake intakeFront, Intake intakeBack,
                                                        Loader loader, BallTrigger ballTrigger, Trigger collect) {
        collect.whileActiveContinuous(new IntakeByDriveTrainAndLoadBalls(joystickValueProvider, intakeFront, intakeBack
                , loader, ballTrigger, () -> LOADER_SPEED, () -> BALL_TRIGGER_SPEED, () -> INTAKE_SPEED));
    }
}
