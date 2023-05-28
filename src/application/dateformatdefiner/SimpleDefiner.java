package application.dateformatdefiner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.zip.DataFormatException;

public class SimpleDefiner {

    private static SimpleDefiner simpleDefiner;
    private String dateFormat;

    private SimpleDefiner(String format) throws DataFormatException {
        defineFormat(format);
    }

    public static SimpleDefiner getSimpleDefiner(String format) throws DataFormatException {
        if (simpleDefiner == null) {
            simpleDefiner = new SimpleDefiner(format);
        }
        return simpleDefiner;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    private void defineFormat(String date) throws DataFormatException {

        String format = null;

        String[] dateFormats = {

                "yyyy-MM-dd",
                "dd-MM-yyyy",
                "dd/MM/yyyy",
                "yyyy/MM/dd",
                "dd.MM.yyyy",
                "yyyy.MM.dd",
                "dd/MM/yy",
                "dd-MM-yy",
                "dd.MM.yy",
                "yyyy-M-d",
                "d-M-yyyy",
                "d/M/yyyy",
                "yyyy/M/d",
                "d.M.yyyy",
                "yyyy.M.d",
                "dd/M/y",
                "d-M-yy",
                "d.M.yy",
                "yyyy-MM-d",
                "d-MM-yyyy",
                "d/MM/yyyy",
                "yyyy/MM/d",
                "d.MM.yyyy",
                "yyyy.MM.d",
                "d/MM/yy",
                "d-MM-yy",
                "d.MM.yy",
                "yyyy-M-dd",
                "dd-M-yyyy",
                "dd/M/yyyy",
                "yyyy/M/dd",
                "dd.M.yyyy",
                "yyyy.M.dd",
                "dd/M/yy",
                "dd-M-yy",
                "dd.M.yy"
        };

        for (String dateFormat : dateFormats) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

            try {
                LocalDate testDate = LocalDate.parse(date,formatter);
                format = dateFormat;
                break;
            } catch (DateTimeParseException ignored) {

            }
        }

        if (format == null) {
            throw new DataFormatException("No such date format found!");
        } else {
            dateFormat = format;
        }
    }
}
