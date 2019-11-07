package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;
import android.graphics.Color;

public class BP {
    double COUNTS_PER_MM = 1;
    public BPHW HW = new BPHW();

    public void encDriveF(double speed, double MM, LinearOpMode OM) {
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

    public void encDriveS(double speed, double MM, LinearOpMode OM) {
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

        HW.mE.setTargetPosition(HW.mE.getCurrentPosition() - (int) (C * MM * d * COUNTS_PER_MM));
        HW.mE.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        HW.mE.setPower(1);
        while (OM.opModeIsActive() && HW.mE.isBusy()) {
            OM.telemetry.addData("Running to", HW.mE.getTargetPosition());
            OM.telemetry.update();
        }
        HW.mE.setPower(0);
        HW.mE.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void Claw(char direction) {
        if (direction == '-') HW.clawServo.setPosition(1);
        else if (direction == '+') HW.clawServo.setPosition(0);
    }

    public int scanforStone(char direction, LinearOpMode OM) {
        SwitchableLight light = (SwitchableLight) HW.colorSensor;
        light.enableLight(true);
        int d = 1;
        if (direction == '-') d = -1;
        int t = 0;

        int c;
        for (c = 0; c != 2; c++) {
            if (isSkystone()) break;
            else encDriveSin(1, d * 8, OM);
            t++;
        }
        light.enableLight(false);
        return (t*d*8);
    }

    public static double[] mecPower(double iX, double iY, double iR) {
        if (Math.abs(iX) <= 0.05) iX = 0;
        if (Math.abs(iY) <= 0.05) iY = 0;
        if (Math.abs(iR) <= 0.05) iR = 0;
        //acquire three desired movement inputs from the
        // driver, y translation, x translation, rotational mostion
        double pA = iR + iY + iX;
        double pB = -iR + iY - iX;
        double pC = -iR + iY + iX;
        double pD = iR + iY - iX;
        //each axis of motion corresponds to a forward
        // or backwards drive of a specific motor.
        // Add or subtract these values to combine all inputs
        double max = Math.max(1, pA);
        max = Math.max(max, pB);
        max = Math.max(max, pC);
        max = Math.max(max, pD);
        pA /= max;
        pB /= max;
        pC /= max;
        pD /= max;
        //double[] returnVal = new double[]();
        return new double[]{pA, pB, pC, pD};
    }

    public boolean isSkystone () {
            float[] hsvValues = new float[3];

            while (hsvValues[0] == 0) {
                NormalizedRGBA values = HW.colorSensor.getNormalizedColors();
                Color.colorToHSV(values.toColor(), hsvValues);
            }
            if (hsvValues[0] > 70) return true;
            else return false;
        }
    public static double[] mecPowerX(double iX, double iY, double iR, double offset, LinearOpMode OM, double robotAngle) {
        if (Math.abs(iX) <= 0.05) iX = 0;
        if (Math.abs(iY) <= 0.05) iY = 0;
        if (Math.abs(iR) <= 0.05) iR = 0;
        double globalAngle = Math.atan2(iY,iX);
        double globalMagnitude = Math.sqrt((iY*iY) + (iX*iX));
        double localAngle = globalAngle + robotAngle;
        double X = Math.cos(globalAngle)*globalMagnitude;
        double Y = Math.sin(globalAngle)*globalMagnitude;
        //acquire three desired movement inputs from the
        // driver, y translation, x translation, rotational mostion
        double pA = iR + Y + X;
        double pB = -iR + Y - X;
        double pC = -iR + Y + X;
        double pD = iR + Y - X;
        //each axis of motion corresponds to a forward
        // or backwards drive of a specific motor.
        // Add or subtract these values to combine all inputs
        double max = Math.max(pA, pA);
        max = Math.max(max, pB);
        max = Math.max(max, pC);
        max = Math.max(max, pD);
        pA /= max;
        pB /= max;
        pC /= max;
        pD /= max;
        //double[] returnVal = new double[]();
        return new double[]{pA, pB, pC, pD};
    }

}
