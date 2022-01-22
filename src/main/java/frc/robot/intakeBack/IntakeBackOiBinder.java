package frc.robot.intakeBack;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.intakeBack.commands.CloseSolenoid;
import frc.robot.intakeBack.commands.IntakeBySpeed;
import frc.robot.intakeBack.commands.OpenSolenoid;

public class IntakeBackOiBinder {

    public IntakeBackOiBinder(IntakeBack intakeBack, JoystickButton intakeBySpeed, JoystickButton openSolenoid , JoystickButton closeSolenoid){
        intakeBySpeed.whileActiveContinuous(new IntakeBySpeed(intakeBack,()->0.3));
        openSolenoid.whileActiveContinuous(new OpenSolenoid(intakeBack));
        closeSolenoid.whileActiveContinuous(new CloseSolenoid(intakeBack));

    }

}

