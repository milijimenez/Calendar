import java.util.ArrayList;

public class TRAPSCalendar {
    ArrayList<Event> calendar = new ArrayList<Event>();

    public TRAPSCalendar() {
        calendar = new ArrayList<Event>();
    }

    //Add an event to the calendar
    public boolean add(Event evt) {
        try {
            calendar.add(evt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Fetch the ith Event added to the calendar
    public Event get(int i) {
        if (i < 0 || i > calendar.size()) {
            return null;
        }
        return calendar.get(i);
    }

    //Fetch the first Event in the calendar whose eventName
    // is equal to the given name
    public Event get(String name) {
        for (int i = 0; i < calendar.size(); i++) {
            if (calendar.get(i).getEventName().equals(name)) {
                return calendar.get(i);
            }
        }
        return null;
    }
    //---------------------------

    //The number of events in the calendar
    public int size() {
        return calendar.size();
    }
    //---------------------------

    //The list of all Events in the order
    // that they were inserted into the calendar
    public ArrayList<Event> list() {
        return calendar;

    }
    //---------------------------

    //public ArrayList<Event> sortByName(){}
    //public ArrayList<Event> sortByDate(){}

    //---------------------------

    public java.lang.String toString() {
        String events = "";
        for (int i = 0; i < calendar.size(); i++) {
            events = "Event name: " + calendar.get(i).getEventName() + " Event Venue: " + calendar.get(i).getEventVenue() + " Event Date: " + calendar.get(i).getDate() +
                    " Tickets Sold: " + calendar.get(i).getTicketsSold() + " Ticket Price: $" + calendar.get(i).getTicketPrice() + " Overhead Costs: $" +
                    calendar.get(i).getOverhead() + " Events Profit: $" + calendar.get(i).getProfit() + " To break even you need to sell " + calendar.get(i).getBreakEvenPoint() + " tickets" + "\n";
        }
        return events;
    }
}


/**
 * This is a "sanity check" to see if your TRAPSCalendar class implements
 * all the proper methods and their signatures.
 * <ul>
 * <li>Put this class in the same src directory as your TRAPSCalendar class.
 * </li>
 * <li>This class <em>must</em> compile to receive a passing grade for the TRAPSCalendar class
 * </li>
 * <li><em>Don't</em> try to run this class--it does nothing.  This is strictly a compile-time
 * method name, method signature, constructor signature check.
 * </li>
 * </ul>
 *
 * @author parks
 *
 */
class TRAPSCalendarSanityCheck {

    public static void main(String[] args) {
        TRAPSCalendar tc = new TRAPSCalendar();
        boolean b = tc.add(new Event());
        int i = tc.size();
        ArrayList<Event> l = tc.list();

        // comment out the next two lines for the Writing Classes Better lab
        // but don't forget to uncomment them for Object Oriented Thinking
        //l = tc.sortByDate();
        //l = tc.sortByProfit();

        Event e = tc.get(1);
        e = tc.get("ename");
    }

}
