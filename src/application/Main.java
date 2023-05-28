package application;

import application.infoclasses.ProgramInfo;

public class Main {

    public static void main(String[] args) {

        ProgramInfo.printProgramInfo();
        Engine applicationEngine = new Engine();
        applicationEngine.execute();
    }
}
