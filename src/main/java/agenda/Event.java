package agenda;

import java.time.*;

public class Event {

    private String myTitle;
    protected LocalDateTime myStart;
    private Duration myDuration;

    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    public boolean isInDay(LocalDate aDay) {
        boolean isInDay = false;
        LocalDate start = myStart.toLocalDate();
        if ((aDay.isAfter(start)) || (aDay.isEqual(start))) {
            if (aDay.isBefore(myStart.plus(myDuration).toLocalDate()) || aDay.isEqual(myStart.plus(myDuration).toLocalDate())) {
                isInDay = true;
            }
        }
        return isInDay;
    }

    public String getTitle() {
        return myTitle;
    }

    public LocalDateTime getStart() {
        return myStart;
    }

    public Duration getDuration() {
        return myDuration;
    }

    @Override
    public String toString() {
        return "Event{" + "myTitle=" + myTitle + ", myStart=" + myStart + ", myDuration=" + myDuration + '}';
    }

}
