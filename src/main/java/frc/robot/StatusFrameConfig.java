package frc.robot;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.StatusFrame;

import java.util.stream.Stream;

import static frc.robot.Constants.LOW_PRIORITY_STATUS_FRAME_PERIODIC;

public class StatusFrameConfig {

    private final IMotorController[] motorController;

    public StatusFrameConfig(IMotorController... motorController) {
        this.motorController = motorController;
    }

    public StatusFrameConfig disablePID1() {
        Stream.of(motorController).forEach(i -> i.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, LOW_PRIORITY_STATUS_FRAME_PERIODIC, 0));
        Stream.of(motorController).forEach(i -> i.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, LOW_PRIORITY_STATUS_FRAME_PERIODIC, 0));
        return this;
    }

    public StatusFrameConfig disableFollowerCAN() {
        Stream.of(motorController).forEach(i -> i.setStatusFramePeriod(StatusFrame.Status_1_General, LOW_PRIORITY_STATUS_FRAME_PERIODIC, 0));
        Stream.of(motorController).forEach(i -> i.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, LOW_PRIORITY_STATUS_FRAME_PERIODIC, 0));
        return this;
    }
}
