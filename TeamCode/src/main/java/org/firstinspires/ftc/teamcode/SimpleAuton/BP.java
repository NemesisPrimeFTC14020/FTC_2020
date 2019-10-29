package org.firstinspires.ftc.teamcode.SimpleAuton;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

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
    public void encDriveS ( double speed, double MM, LinearOpMode OM){
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
}
