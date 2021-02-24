public class Event {

    private String eventName;
    private String eventVenue;
    private String date;
    private int ticketsSold;
    private int ticketPrice;
    private int overhead;

    public Event() {
    }

    //Create an event where only the name and venue are known
    public Event(String eventName, String eventVenue) {
        this.eventName = eventName;
        this.eventVenue = eventVenue;
    }

    public Event(String eventName, String eventVenue, int venueCapacity, String date,
                 int ticketsSold, int ticketPrice, int overhead) {
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.date = date;
        if (ticketsSold > 0) {
            this.ticketsSold = ticketsSold;
        } else {
            this.ticketsSold = 0;
        }
        this.ticketPrice = ticketPrice;
        this.overhead = overhead;
    }

    public boolean sellTickets(int numberOfTickets) {
        if (ticketsSold > 0) {
            this.ticketsSold += ticketsSold;
            return true;
        }
        return false;
    }

    public int getProfit() {
        return (this.ticketsSold * this.ticketPrice) - this.overhead;
    }

    public int getBreakEvenPoint() {
        return this.overhead / this.ticketPrice;
    }

    public int compareName(Event other) {
        return this.eventName.compareTo(other.eventName);
    }

    int compareDate(Event other) {
        return this.date.compareTo(other.date);
    }

    int compareProfit(Event other) {
        if (this.getProfit() != other.getProfit()) {
            return this.getProfit() > other.getProfit() ? 1 : -1;
        }
        return 0;
    }

    //getEventName + setEventName
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    //getEventVenue + setEventName
    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    //getTicketsSold
    public int getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    //getTicketPrice + setTicketPrice
    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    //getOverhead + setOverhead
    public int getOverhead() {
        return overhead;
    }

    public void setOverhead(int overhead) {
        this.overhead = overhead;
    }

    //getDate + setDate
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //toString
    public String toString() {
        String s = "";
        return s;
    }

}

class EventSanityCheck {

    public EventSanityCheck() {
        Event e = new Event();
        e = new Event("party", "venue");
        e = new Event("bday2", "bobAndJane2",55, "2019-01-02", 13, 12, 112);
        String s = e.getDate();
        s = e.getEventName();
        s = e.getEventVenue();
        s = e.toString();
        int i = e.compareDate(e);
        i = e.compareName(e);
        i = e.compareProfit(e);
        i = e.getBreakEvenPoint();
        i = e.getOverhead();
        i = e.getProfit();
        i = e.getTicketPrice();
        i = e.getTicketsSold();
        boolean b = e.sellTickets(2);
        e.setDate("2019-01-02");
        e.setEventName("name");
        e.setEventVenue("ven");
        e.setOverhead(2);
        e.setTicketPrice(5);
        e.setTicketsSold(3);
    }
}
