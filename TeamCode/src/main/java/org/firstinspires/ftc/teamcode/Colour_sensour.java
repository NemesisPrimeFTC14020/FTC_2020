package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="colour sensour", group="A")

public class Colour_sensour extends LinearOpMode {

    private NormalizedColorSensor sensor = null;

    @Override
    public void runOpMode() {
        sensor = hardwareMap.get(NormalizedColorSensor.class, "test");
        waitForStart();

        while (opModeIsActive()) {

            telemetry.update();
        }

    }
}
