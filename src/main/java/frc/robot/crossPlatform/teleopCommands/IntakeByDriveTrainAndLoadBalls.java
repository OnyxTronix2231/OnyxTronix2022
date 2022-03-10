package frc.robot.crossPlatform.teleopCommands;

import frc.robot.driveTrainJoystickValueProvider.DriveTrainJoystickValueProvider;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.LoadBalls;
import frc.robot.conveyor.loader.Loader;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class IntakeByDriveTrainAndLoadBalls extends ParallelCommandGroup {

    public IntakeByDriveTrainAndLoadBalls(DriveTrainJoystickValueProvider joystickValueProvider, Intake intakeFront, Intake intakeBack,
                                          Loader loader, BallTrigger ballTrigger, DoubleSupplier loaderSpeedSupplier,
                                          DoubleSupplier intakeSpeedSupplier) {
        super(
                new LoadBalls(loader, ballTrigger, loaderSpeedSupplier::getAsDouble),
                new IntakeByDriveTrain(intakeFront, intakeBack, intakeSpeedSupplier, joystickValueProvider));
    }
}
