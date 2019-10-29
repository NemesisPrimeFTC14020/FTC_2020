package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;


@TeleOp(name="colour sensour", group="A")

public class Colour_sensour extends LinearOpMode {

    private NormalizedColorSensor sensor = null;

    @Override
    public void runOpMode() {
        sensor = hardwareMap.get(NormalizedColorSensor.class, "sensor_color");
        float[] hsvValues = new float[3];
        waitForStart();

        while (opModeIsActive()) {
            NormalizedRGBA values = sensor.getNormalizedColors();
            Color.colorToHSV(values.toColor(), hsvValues);

            telemetry.addData("H", hsvValues[0]);
            telemetry.addData("S", hsvValues[1]);
            telemetry.addData("V", hsvValues[2]);


            if (hsvValues[0] == 0) {
                telemetry.update();
                continue;
            }
            else if (hsvValues[0] < 70) telemetry.addLine("It is just a boring stone.");
            else if (hsvValues[0] < 185) telemetry.addLine("It is a skystone! Go go go score it now");
            else telemetry.addLine("It is neither a stone nor a skystone. What are you looking at?");

            telemetry.update();
        }

    }
}