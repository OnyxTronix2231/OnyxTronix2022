package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class ConveyorComponentsA implements ConveyorComponents {
        private final WPI_TalonFX firstMotor;
        private final WPI_TalonFX secondMotor;

    public ConveyorComponentsA(WPI_TalonFX firstMotor, WPI_TalonFX secondMotor) {
        firstMotor = new WPI_TalonFX();
        secondMotor = new WPI_TalonFX();


    }

}
