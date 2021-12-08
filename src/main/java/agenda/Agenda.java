package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    
ArrayList<Event> eventList;

    public Agenda() {
        this.eventList = new ArrayList<>();
    }

    public void addEvent(Event e) {
        eventList.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        for (int i = 0; i < eventList.size(); i++) {
            if(eventList.get(i).getStart() == day){
                return eventList.get(i);
            }
        }
}
}