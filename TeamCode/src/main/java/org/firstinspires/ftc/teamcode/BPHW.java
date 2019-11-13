package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevSPARKMini;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

public class BPHW {

     public DcMotor mA = null;
     public DcMotor mB = null;
     public DcMotor mC = null;
     public DcMotor mD = null;
    // add encoders
    DcMotor mE = null;
    public BNO055IMU imu = null;
    Servo clawServo = null;

    NormalizedColorSensor colorSensor = null;

    public void initHW(LinearOpMode OM) {

        mA=OM.hardwareMap.get(DcMotor.class, "motor A");
        mB=OM.hardwareMap.get(DcMotor.class, "motor B");
        mC=OM.hardwareMap.get(DcMotor.class, "motor C");
        mD=OM.hardwareMap.get(DcMotor.class, "motor D");
        mE= OM.hardwareMap.get(DcMotor.class,"elevator");
        imu =OM.hardwareMap.get(BNO055IMU.class, "imu");
        clawServo=OM.hardwareMap.get(Servo.class, "servo");
        colorSensor = OM.hardwareMap.get(NormalizedColorSensor.class, "color");

        mA.setDirection(DcMotor.Direction.REVERSE);
        mD.setDirection(DcMotor.Direction.REVERSE);

        mA.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mC.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mE.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        mA.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mC.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mE.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
}
