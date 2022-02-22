package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.climber.Climber;
import java.util.function.DoubleSupplier;

import static frc.robot.climber.commands.ClimberCommandConstants.*;

public class ClimbByPhase extends ConditionalCommand {

    private final Climber climber;

    public ClimbByPhase(Climber climber, DoubleSupplier speedSupplier) {
        super(new MoveArmsByDistance(climber, () -> ARM_OPEN_DISTANCE).
                        andThen(new MoveArmsByDistance(climber, () -> ARM_CLOSE_DISTANCE)),
                new ClimbLevel(climber, speedSupplier), climber::isFirstPhase);
        this.climber = climber;
    }

    @Override
    public void end(boolean interrupted) {
        climber.setFirstPhase(false);
    }
}
