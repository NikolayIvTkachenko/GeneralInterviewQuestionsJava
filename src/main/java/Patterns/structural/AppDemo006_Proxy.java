package Patterns.structural;

public class AppDemo006_Proxy {

    public static void main(String[] args) {

        MachineI machine01 = new MachineProxy(new SiemensMachine());
        machine01.working();

    }
}

interface MachineI {
    void working();
}

class SiemensMachine implements MachineI{

    @Override
    public void working() {
        System.out.println("Siemens device working and doing details for spaceship!");
    }
}

class MachineProxy implements MachineI {

    MachineI machineI;

    public MachineProxy(MachineI machineI){
        this.machineI = machineI;
    }

    @Override
    public void working() {
        System.out.println("Logging work Siemens");
        machineI.working();
    }
}
