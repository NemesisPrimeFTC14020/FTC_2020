package org.firstinspires.ftc.teamcode.SimpleAuton;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;
import android.graphics.Color;

public class BP {
    double COUNTS_PER_MM = 1;
    public BPHW HW = new BPHW();
    public fstAuton Auton = new fstAuton();

    public void encDriveF(double speed, double MM, LinearOpMode OM){
        int newATarget;
        int newBTarget;
        int newCTarget;
        int newDTarget;
        if (OM.opModeIsActive()) {
            newATarget = HW.mA.getCurrentPosition() - (int) (MM * COUNTS_PER_MM);
            newBTarget = HW.mB.getCurrentPosition() - (int) (MM * COUNTS_PER_MM);
            newCTarget = HW.mC.getCurrentPosition() - (int) (MM * COUNTS_PER_MM);
            newDTarget = HW.mD.getCurrentPosition() - (int) (MM * COUNTS_PER_MM);
            HW.mA.setTargetPosition(newATarget);
            HW.mB.setTargetPosition(newBTarget);
            HW.mC.setTargetPosition(newCTarget);
            HW.mD.setTargetPosition(newDTarget);
            HW.mA.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            HW.mB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            HW.mC.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            HW.mD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            HW.mA.setPower(Math.abs(speed));
            HW.mC.setPower(Math.abs(speed));
            HW.mD.setPower(Math.abs(speed));
            while (OM.opModeIsActive() &&
                    (HW.mA.isBusy() && HW.mB.isBusy() && HW.mC.isBusy() && HW.mD.isBusy())) {
                OM.telemetry.addData("Path1", "Running to %7d :%7d :%7d :%7d", newATarget, newBTarget, newCTarget, newDTarget);
                OM.telemetry.update();
            }
            HW.mA.setPower(0);
            HW.mB.setPower(0);
            HW.mC.setPower(0);
            HW.mD.setPower(0);
            HW.mA.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            HW.mB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            HW.mC.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            HW.mD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
    public void encDriveS(double speed, double MM, LinearOpMode OM){
        int newATarget;
        int newBTarget;
        int newCTarget;
        int newDTarget;
        if (OM.opModeIsActive()) {
            newATarget = HW.mA.getCurrentPosition() - (int) (MM * COUNTS_PER_MM);
            newBTarget = HW.mB.getCurrentPosition() + (int) (MM * COUNTS_PER_MM);
            newCTarget = HW.mC.getCurrentPosition() - (int) (MM * COUNTS_PER_MM);
            newDTarget = HW.mD.getCurrentPosition() + (int) (MM * COUNTS_PER_MM);
            HW.mA.setTargetPosition(newATarget);
            HW.mB.setTargetPosition(newBTarget);
            HW.mC.setTargetPosition(newCTarget);
            HW.mD.setTargetPosition(newDTarget);
            HW.mA.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            HW.mB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            HW.mC.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            HW.mD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            HW.mA.setPower(Math.abs(speed));
            HW.mB.setPower(Math.abs(speed));
            HW.mC.setPower(Math.abs(speed));
            HW.mD.setPower(Math.abs(speed));
            while (OM.opModeIsActive() &&
                    (HW.mA.isBusy() && HW.mB.isBusy() && HW.mC.isBusy() && HW.mD.isBusy())) {
                OM.telemetry.addData("Path1", "Running to %7d :%7d :%7d :%7d", newATarget, newBTarget, newCTarget, newDTarget);
                OM.telemetry.update();
            }
            HW.mA.setPower(0);
            HW.mB.setPower(0);
            HW.mC.setPower(0);
            HW.mD.setPower(0);
            HW.mA.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            HW.mB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            HW.mC.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            HW.mD.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
    public void encDriveFin(double speed, double in, LinearOpMode OM) {
        double MM = 25.4 * in;
        double C = 1;
        // never forget to add the constant C
        encDriveF(speed, C * MM, OM);
    }
    public void encDriveSin(double speed, double in, LinearOpMode OM) {
        double MM = 25.4 * in;
        double C = 1;
        // he's just a constant, might as well just call it C (calibration factor)
        encDriveS(speed, C * MM, OM);
    }
    public void yClaw(char direction, double in, LinearOpMode OM) {
        double MM = 25.4 * in;
        int d = 1;
        if (direction == '-') d = -1;
        double C = 1;

        HW.elevator.setTargetPosition(HW.elevator.getCurrentPosition() - (int) (C * MM * d * COUNTS_PER_MM));
        HW.elevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        HW.elevator.setPower(1);
        while (OM.opModeIsActive() && HW.elevator.isBusy()) {
            OM.telemetry.addData("Running to", HW.elevator.getTargetPosition());
            OM.telemetry.update();
        }
        HW.elevator.setPower(0);
        HW.elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void Claw(char direction) {
        if (direction == '-') HW.clawServo.setPosition(1);
        else if (direction == '+') HW.clawServo.setPosition(0);
    }
    public int scanforStone(char direction, LinearOpMode OM) {
        SwitchableLight light = (SwitchableLight)HW.colorSensor;
        light.enableLight(true);
        int d = 1;
        if (direction == '-') d = -1;
        int t = 0;

        int c;
        for (c = 0; c != 2; c++) {
            if (Auton.bp.isSkystone()) break;
            else Auton.bp.encDriveSin(1, d * 8, OM);
            t++;
        }
        light.enableLight(false);
        return t * d * 8;
    }
    public boolean isSkystone() {
        float[] hsvValues = new float[3];

        while (hsvValues[0] == 0){
            NormalizedRGBA values = HW.colorSensor.getNormalizedColors();
            Color.colorToHSV(values.toColor(), hsvValues);
        }
        if (hsvValues[0] > 70) return true;
        else return false;
    }
}
