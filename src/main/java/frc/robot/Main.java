/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Do NOT add any static variables to this class, or any initialization at all. Unless you know what
 * you are doing, do not modify this file except to change the parameter class to the startRobot
 * call.
 */
public final class Main {

    private Main() {
    }

    /**
     * Main initialization function. Do not perform any initialization here.
     *
     * <p>If you change your main robot class, change the parameter type.
     */
    public static void main(String... args) {
        RobotBase.startRobot(Robot::new);
    }

    public static class ConveyorConstants {

        public static final class ConveyorConstantsBase {
            static final int FIRST_MOTOR_ID = 0;
            static final int SECOND_MOTOR_ID = 0;
        }

        public static class Conveyor extends SubsystemBase {

            private final Conveyor conveyor;

            public Conveyor(Conveyor conveyor) {
                this.conveyor = conveyor;
            }



        }
    }
}
