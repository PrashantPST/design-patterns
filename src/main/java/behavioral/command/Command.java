package behavioral.command;


public interface Command {
    void execute();
}

/*
You'll see the variable landingGear in the LandingGearDownCommand class. This is called the Receiver. It is the object that actually knows how to lower
the landing gear and does the job, which is why it is called the receiver because it receives the request and processes it.
The LandingGearDownCommand is the Command in pattern-speak. The command is composed with the receiver that actually contains the logic
to perform the requested action
 */
class LandingGearDownCommand implements Command {

    // This is called the receiver of the request and
    // actually has the logic to perform the action
    LandingGear landingGear;

    public LandingGearDownCommand(LandingGear landingGear) {
        this.landingGear = landingGear;
    }

    @Override
    public void execute() {
        landingGear.up();
    }
}

class InstrumentPanel {

    // Only two commands for now
    Command[] commands = new Command[2];

    public InstrumentPanel() {

    }

    public void setCommand(int i, Command command) {
        commands[i] = command;
    }

    public void lowerLandingGear() {
        // Assuming that the client correctly sets the first
        // index to be the landing gear lower command
        commands[0].execute();
    }

    public void retractLandingGear() {
        commands[1].execute();
    }
}

class Main {
    public static void main(String[] args) {
        LandingGear landingGear = new LandingGear();
        LandingGearDownCommand landingGearDownCommand = new LandingGearDownCommand(landingGear);
        LandingGearUpCommand landingGearUpCommand = new LandingGearUpCommand(landingGear);

        // Create the instrument panel
        InstrumentPanel instrumentPanel = new InstrumentPanel();

        // Assign the commands
        instrumentPanel.setCommand(0, landingGearUpCommand);
        instrumentPanel.setCommand(1, landingGearDownCommand);

        // Lower the landing gear
        instrumentPanel.lowerLandingGear();

        // Retract the landing gear
        instrumentPanel.retractLandingGear();
    }
}
