package GUI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayOfMonth {
    int year;
    int month;

    List<LocalDate> dateList;

    public DayOfMonth(LocalDate date){
        year = date.getYear();
        month = date.getMonthValue();
        dateList = new ArrayList<>();

        addDaysToList();
    }

    public void addDaysToList(){
        LocalDate date = LocalDate.of(year, month, 1);
        LocalDate startDate = countDaysBefore(date);
        for(int i = 0; i < 42; i++){
            dateList.add(startDate);
            startDate = startDate.plusDays(1);
        }
    }

    public LocalDate countDaysBefore(LocalDate date){
        //Check how many days after monday the month starts with
        int day = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
        int daysBefore = 7 - (day -1);

        return date.minusDays(daysBefore);
    }


    //Sparar denna om den behövs senare i nån dags-vy eller dylikt
    public LocalDate getLastDayOfMonth(LocalDate date){
        LocalDate firstDateOfThisMonth = LocalDate.of(date.getYear(), date.getMonth(), 1);
        LocalDate firstDateOfNextMonth = firstDateOfThisMonth.plusMonths(1);

        return firstDateOfNextMonth.minusDays(1);
    }

    public List<LocalDate> getDateList() {
        return dateList;
    }
}
