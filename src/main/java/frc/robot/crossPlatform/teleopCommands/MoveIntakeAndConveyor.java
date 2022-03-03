package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.LoadBalls;
import frc.robot.conveyor.loader.Loader;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.MoveIntakeBySpeed;

import java.util.function.DoubleSupplier;


public class MoveIntakeAndConveyor extends ParallelCommandGroup {

    public MoveIntakeAndConveyor(Intake intake, BallTrigger ballTrigger, Loader loader,
                                 DoubleSupplier loaderSpeedSupplier, DoubleSupplier ballTriggerSpeedSupplier,
                                 DoubleSupplier intakeSpeedSupplier) {
        super(new LoadBalls(loader, ballTrigger, loaderSpeedSupplier,
                        ballTriggerSpeedSupplier),
                new MoveIntakeBySpeed(intake, intakeSpeedSupplier));
    }
}
