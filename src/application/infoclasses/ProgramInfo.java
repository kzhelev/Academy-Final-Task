package application.infoclasses;

public class ProgramInfo {

    public static void printProgramInfo() {
        System.out.println("PROGRAM INFORMATION");
        System.out.print(System.lineSeparator());
        System.out.println(Constants.SUPPORTED_FILE_FORMATS);
        System.out.println(Constants.SUPPORTED_DATE_FORMATS);
        System.out.println(Constants.WARNING);
        System.out.print(System.lineSeparator());
    }
}
