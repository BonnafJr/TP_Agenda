package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {

    private ChronoUnit frequence;
    private List<LocalDate> lesExceptions;

    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequence) {
        super(title, start, duration);
        this.frequence = frequence;
        lesExceptions = new ArrayList<>();
    }

    public void addException(LocalDate date) {
        lesExceptions.add(date);
    }

    public ChronoUnit getFrequence() {
        return frequence;
    }
    
    @Override
    public boolean isInDay(LocalDate aDay) {
        if (super.isInDay(aDay)) {
            return true;
        }
        if (!lesExceptions.stream().noneMatch(date -> (aDay.isEqual(date)))) {
            return false;
        }
        int year = myStart.getYear();
        int month = myStart.getMonthValue();
        int day = myStart.getDayOfMonth();

        while (aDay.isAfter(LocalDate.of(year, month, day))) {
            if (super.isInDay(LocalDate.of(year, month, day))) {
                return true;
            }else{
                if(ChronoUnit.DAYS==frequence){
                    day+=1;
                }
                if(ChronoUnit.WEEKS==frequence){
                    day+=7;
                }
                if(ChronoUnit.MONTHS==frequence){
                    month+=1;
                }
            }
        }
        return false;
    }
}
