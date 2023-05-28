package application.mainclasses;

import application.dateformatdefiner.SimpleDefiner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.zip.DataFormatException;

public class WorkPeriod {

    private final LocalDate dateFrom;
    private final LocalDate dateTo;

    public WorkPeriod(String dateFrom, String dateTo) throws DataFormatException, DateTimeParseException {

        this.dateFrom = parseDate(dateFrom);
        this.dateTo = parseDate(dateTo);
    }

    private LocalDate parseDate(String input) throws DataFormatException, DateTimeParseException {

        String format = null;

        SimpleDefiner formatDefiner = null;

        formatDefiner = SimpleDefiner.getSimpleDefiner(input);

        format = formatDefiner.getDateFormat();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);

        input = !input.equals("NULL") ? input : LocalDate.now().format(dateTimeFormatter);

        return LocalDate.parse(input,dateTimeFormatter);
    }

    public LocalDate getDateFrom() {

        return dateFrom;
    }

    public LocalDate getDateTo() {

        return dateTo;
    }
}
