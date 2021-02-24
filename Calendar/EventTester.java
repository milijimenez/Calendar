public class EventTester {

    // Displays Event using its Accesor methods
    static void displayEvent(Event event){
        System.out.println("Name: " + event.getEventName());
        System.out.println("Venue: " + event.getEventVenue());
        System.out.println("Date: " + event.getDate());
        System.out.println("Tickets Sold: " + event.getTicketsSold());
        System.out.println("Price per ticket: " + event.getTicketPrice());
        System.out.println("Overhead: " + event.getOverhead());
    }

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
// Create three event objects
// yoga object using default contstructor
// and set the values using mutators
        Event yoga = new Event();
        yoga.setEventName("Yoga");
        yoga.setEventVenue("FameHall");
        yoga.setDate("2020-07-15");
        yoga.setTicketsSold(10);
        yoga.setTicketPrice(15);
        yoga.setOverhead(100);

// lasherShow event using name and venue constructor
        Event laserShow = new Event("LaserShow", "AGS Hall");
        laserShow.setDate("2020-07-15");
        laserShow.setTicketsSold(20);
        laserShow.setTicketPrice(30);
        laserShow.setOverhead(150);

//concert show using fully specified constructor
        Event concert = new Event("Concert By Sarah", "Olympics Park", 25, "2020-06-30",20,20,200);
                //"Concert By Sarah", "Olympics Park", "2020-06-30", 25, 20, 200);


// display objects
        System.out.println("Yoga Event Details: ");
        displayEvent(yoga);
        System.out.println("\n");
        System.out.println("Laser Show Event Details: ");
        displayEvent(laserShow);
        System.out.println("\n");
        System.out.println("Concert Event Details: ");
        displayEvent(concert);

// Test getBreakEvenPoint method
        System.out.println("\n");
        System.out.println("Break Even Points: ");
        System.out.println("Yoga: " + yoga.getBreakEvenPoint());
        System.out.println("Laser Show: " + laserShow.getBreakEvenPoint());
        System.out.println("Concert: " + concert.getBreakEvenPoint());

//Test profit methods
        System.out.println("\n");
        System.out.println("Current expected profits: ");
        System.out.println("Yoga: " + yoga.getProfit());
        System.out.println("Laser Show: " + laserShow.getProfit());
        System.out.println("Concert: " + concert.getProfit());

// Compare profits
        System.out.println("\n");
        System.out.println("Compare profit method: ");
        System.out.println("yoga.compareProfit(laserShow): "
                + yoga.compareProfit(laserShow));
        System.out.println("yoga.compareProfit(concert): "
                + yoga.compareProfit(concert));
        System.out.println("laserShow.compareProfit(concert): "
                + laserShow.compareProfit(concert));
        System.out.println("laserShow.compareProfit(laserShow): "
                + laserShow.compareProfit(laserShow));

// Sell ticket method
        System.out.println("\n");
        System.out.println("Sell 150 tickets for yoga event...");
        yoga.sellTickets(150);
        System.out.println("Sell 2 tickets for laserShow event...");
        laserShow.sellTickets(2);
        System.out.println("Sell -10 tickets for concert event...");
        concert.sellTickets(-10);

        System.out.println("\n");
        System.out.println("Display evetns to verify tickets sold..");
        System.out.println("Yoga Event Details: ");
        displayEvent(yoga);
        System.out.println("\n");
        System.out.println("Laser Show Event Details: ");
        displayEvent(laserShow);
        System.out.println("\n");
        System.out.println("Concert Event Details: ");
        displayEvent(concert);

// Compare date method
        System.out.println("\n");
        System.out.println("Compare date method: ");
        System.out.println("yoga.compareDate(laserShow): "
                + yoga.compareDate(laserShow));
        System.out.println("concert.compareDate(yoga): "
                + concert.compareDate(yoga));
        System.out.println("laserShow.compareDate(concert): "
                + laserShow.compareDate(concert));

// Compare name
        System.out.println("\n");
        System.out.println("Compare profit method: ");
        System.out.println("yoga.compareName(laserShow): "
                + yoga.compareName(laserShow));
        System.out.println("concert.compareName(laserShow): "
                + concert.compareName(laserShow));
        System.out.println("laserShow.compareName(laserShow): "
                + laserShow.compareName(laserShow));
    }
}