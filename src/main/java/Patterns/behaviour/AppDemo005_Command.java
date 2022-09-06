package Patterns.behaviour;

import java.util.ArrayList;
import java.util.List;

public class AppDemo005_Command {

    public static void main(String[] args) {

        Receiver receiver = new Receiver();
        receiver.addCommand(new MouseClick());
        receiver.addCommand(new MousePress());
        receiver.RunCommand();


    }

}

interface Command{
    void execute();
    void revert();
}

class MouseClick implements Command {
    @Override
    public void execute() {
        System.out.println("Click commnad");
    }

    @Override
    public void revert() {
        System.out.println("Click commnad revert");
    }
}

class MousePress implements Command {
    @Override
    public void execute() {
        System.out.println("Click mouse press");
    }

    @Override
    public void revert() {
        System.out.println("Click mouse press revert");
    }

}

class Receiver {
    List<Command> commandList = new ArrayList<>();

    void addCommand(Command command){
        commandList.add(command);
    }

    void RunCommand(){
        try {
            for (Command command : commandList) {
                command.execute();
            }
        }catch (Exception e){
            System.out.println("Error messagee: " + e.getMessage());
            for (Command command: commandList){
                command.revert();
            }
        }
    }
}