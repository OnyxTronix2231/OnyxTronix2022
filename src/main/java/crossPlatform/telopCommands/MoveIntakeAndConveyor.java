package crossPlatform.telopCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.LoadBalls;
import frc.robot.conveyor.loader.Loader;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.MoveIntakeBySpeed;

import java.util.function.DoubleSupplier;

import static crossPlatform.telopCommands.CrossPlatformConstants.*;


public class MoveIntakeAndConveyor extends ParallelCommandGroup {
    public MoveIntakeAndConveyor(Intake intake, BallTrigger ballTrigger, Loader loader) {
        super(new LoadBalls(loader, ballTrigger, ()-> LOADER_SPEED, ()-> BALL_TRIGGER_SPEED ),
                new MoveIntakeBySpeed(intake, ()-> INTAKE_SPEED));
    }
}
