// Container for all of the code our team creates for the robot.
package org.firstinspires.ftc.teamcode;

// Imports code from other classes. This allows us to use the FTC hardware in our software.
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

// Sets the name and group (order) that the mode will show in the list on the phone. "TeleOp" means manual driving.
@TeleOp(name = "Teleoperation (TeleOp)", group = "A")

// Class which contains our robot code. "extends" means applying pre-existing classes to the code, which @Override will ensure we can
// replace the samples with our own code.
public class kitbotOp extends LinearOpMode {

    // This creates our motor objects. We can reference this to perform actions or gather data.
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;

    @Override
    // Method which runs when you press "INIT". When it is interrupted by pressing the button, code is run.
    public void runOpMode() throws InterruptedException {
        // This is telemetry, data that we can see on the phone while the code is running.
        // This is most useful as a debugging tool to determine software issues and fix them.
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // This maps our motor objects which connects our code to the motors on the robot.
        leftMotor = hardwareMap.get(DcMotor.class, "left motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right motor");

        // Waits until the "Play' button is pressed.
        waitForStart();

        // While the opMode is running, the code in this "while" loop will run
        while (opModeIsActive()) {

            // 64 bit data type that holds decimal values. Worst for performance, but it is such a
            // negligible difference that we use it anyway for its ability to hold highly specific values.
            double leftPower;
            double rightPower;

            // This records the current joystick input on the gamepad.
            double drive = gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            // This is the method which sets the power on the motors (causes it to drive!)
            // Turning works by giving the left motors a positive power and the right motors a negative power.
            // If the power itself is negative, then the robot turns the other way.
            // Range normalizes, or sets into an acceptable range, the values the motors can be set into.
            // For example, if drive and turn are both 1, this gives 2 for the left motor.
            // The motor can only be set power from (-1, 1) so it is set to 1 instead.
            leftMotor.setPower(Range.clip(drive + turn, -1.0, 1.0));
            rightMotor.setPower(Range.clip(drive - turn, -1.0, 1.0));
        }
        // Stops motors when stop is pressed.
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
}
