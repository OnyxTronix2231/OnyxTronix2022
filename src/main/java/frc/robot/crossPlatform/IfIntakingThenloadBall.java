package frc.robot.crossPlatform;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.loader.Loader;
import frc.robot.trigger.BallTrigger;
import frc.robot.intake.Intake;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class IfIntakingThenloadBall extends ConditionalCommand {
    public IfIntakingThenloadBall(BallTrigger ballTrigger, Loader loader,Intake intake, DoubleSupplier triggerSpeedSupplier,DoubleSupplier loaderSpeedSupplier, Command onTrue, Command onFalse, BooleanSupplier condition) {
        super(new LoadBall(ballTrigger,loader,loaderSpeedSupplier,triggerSpeedSupplier), onFalse, intake::isMotorSpin);
    }
}
