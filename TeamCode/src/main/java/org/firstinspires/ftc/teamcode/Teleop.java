package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import java.util.ArrayList;

@TeleOp(name = "telOp", group = "Linear OpMode")
public class Teleop extends LinearOpMode {
    public BP bp = new BP();
    @Override
    public void runOpMode() throws InterruptedException {
        bp.HW.initHW(this);
        double[] powers;
        boolean servoPos = true;
        waitForStart();
        while(opModeIsActive()) {
            powers = bp.mecPower(gamepad1.left_stick_x, gamepad1.left_stick_y,gamepad1.right_stick_x);

            bp.HW.mA.setPower(powers[0]);
            bp.HW.mB.setPower(powers[1]);
            bp.HW.mC.setPower(powers[2]);
            bp.HW.mD.setPower(powers[3]);
            if (gamepad1.a) servoPos = !servoPos;
            if (gamepad1.x) bp.HW.mE.setPower(-1);
            else if (gamepad1.y)  bp.HW.mE.setPower(1);
            else bp.HW.mE.setPower(0);
            if (servoPos = true) bp.HW.clawServo.setPosition(1);
            else bp.HW.clawServo.setPosition(0);
        }
        bp.HW.mA.setPower(0);
        bp.HW.mB.setPower(0);
        bp.HW.mC.setPower(0);
        bp.HW.mD.setPower(0);
        bp.HW.mE.setPower(0);
    }
}