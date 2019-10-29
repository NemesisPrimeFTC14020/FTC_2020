package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="nick = 1520", group="A")

public class Servo_sample extends LinearOpMode {

    private Servo test = null;

    @Override
    public void runOpMode() {
        test = hardwareMap.get(Servo.class, "test");
        double position = 0;
        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.x && position < 1) position += 0.1;
            if (gamepad1.b && position > 0) position -= 0.1;

            if (gamepad1.dpad_up) test.setPosition(position);

            telemetry.addData("Target location", test.getPosition());
            telemetry.update();
        }

    }
}
