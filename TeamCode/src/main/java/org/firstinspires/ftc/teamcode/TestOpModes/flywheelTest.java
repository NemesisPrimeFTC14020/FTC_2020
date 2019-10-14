package org.firstinspires.ftc.teamcode.TestOpModes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="flywheelTest", group="Linear Opmode")

public class flywheelTest extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
        DcMotor mA = hardwareMap.dcMotor.get ("motor A");
        DcMotor mB = hardwareMap.dcMotor.get ("motor B");
        mB.setDirection(DcMotor.Direction.REVERSE);
        mB.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        while(opModeIsActive()) {
           mA.setPower(1);
           mB.setPower(1);
        }
        mA.setPower(0);
        mB.setPower(1);
    }
}
