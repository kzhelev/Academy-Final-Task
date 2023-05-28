package application.infoclasses;

public class Constants {

    public static final String SUPPORTED_FILE_FORMATS = "The program only supports CSV and TXT file formats.";

    public static final String SUPPORTED_DATE_FORMATS = "The program supports the following date formats: \"yyyy-MM-dd\", \"dd-MM-yyyy\", \"dd/MM/yyyy\","+
            " \"yyyy/MM/dd\", \"dd.MM.yyyy\", \"yyyy.MM.dd\", \"dd/MM/yy\", \"dd-MM-yy\",\"yyyy-M-dd\",\n\"dd-M-yyyy\", \"dd/M/yyyy\", " +
            "\"yyyy/M/dd\", \"dd.M.yyyy\", \"yyyy.M.dd\", \"dd/M/yy\", \"dd-M-yy\" \"yyyy-MM-d\",\"d-MM-yyyy\", \"d/MM/yyyy\", " +
            "\"yyyy/MM/d\", \"d.MM.yyyy\", \"yyyy.MM.d\",\n\"d/MM/yy\", \"d-MM-yy\" \"yyyy-M-d\",\"d-M-yyyy\", \"d/M/yyyy\", " +
            "\"yyyy/M/d\", \"d.M.yyyy\", \"yyyy.M.d\", \"d/M/yy\", \"d-M-yy\";";

    public static final String WARNING = "Please ensure that dates in the file match one of the supported date formats" +
            " listed above. Otherwise, the program may fail or produce incorrect output.";


}