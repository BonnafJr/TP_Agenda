package agenda;

import java.time.LocalDate;
import java.util.*;

public class Agenda {

    private final List<Event> eventList;

    public Agenda() {
        eventList = new ArrayList<>();
    }

    public void addEvent(Event e) {
        eventList.add(e);
    }

 
    public List<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> eventsDay = new ArrayList<>();
        for (Event e : eventList) {
            if (e.isInDay(day)) {
                eventsDay.add(e);
            }
        }
        return eventsDay;
    }

    public List<Event> findByTitle(String title) {
        ArrayList<Event> eventsDay = new ArrayList<>();
        eventList.stream().filter(e -> (e.getTitle().equals(title))).forEachOrdered(e -> {
            eventsDay.add(e);
        });
        return eventsDay;
    }

    public boolean isFreeFor(Event e) {
        return eventList.stream().noneMatch(event -> (e.getStart().plus(e.getDuration()).isAfter(event.getStart()) && e.getStart().isBefore(event.getStart().plus(event.getDuration()))));
    }

}
