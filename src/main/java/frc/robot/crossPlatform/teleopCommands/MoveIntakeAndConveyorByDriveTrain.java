package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class MoveIntakeAndConveyorByDriveTrain extends ParallelCommandGroup {

    public MoveIntakeAndConveyorByDriveTrain(DriveTrain driveTrain, Intake intakeFront, Intake intakeBack,
                                             Loader loader, BallTrigger ballTrigger, DoubleSupplier loaderSpeedSupplier,
                                             DoubleSupplier ballTriggerSpeedSupplier,
                                             DoubleSupplier intakeSpeedSupplier) {
        super(//new LoadBalls(loader, ballTrigger, loaderSpeedSupplier::getAsDouble,
                //        ballTriggerSpeedSupplier::getAsDouble),
                new IntakeByDriveTrain(intakeFront, intakeBack, intakeSpeedSupplier, driveTrain, 0.1));
    }
}
