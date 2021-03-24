import javax.swing.*;
import java.awt.event.ActionEvent;

public class TRAPSGUIProject {
    //07.20.20 need to change previous code for capacity [done]
    //improvements ideas: adding a search button by name
    //Jlabels
    private JLabel welcome;
    private JLabel eventName;
    private JLabel eventVenue;
    private JLabel venueCapacity;
    private JLabel eventDate;
    private JLabel ticketsSold;
    private JLabel tickePrice;
    private JLabel overheadCost;
    private JLabel eventListLabel;
    //Jtext
    private JTextField name;
    private JTextField venue;
    private JTextField capacity;
    private JTextField date;
    private JTextField tSold;
    private JTextField tprice;
    private JTextField overhead;
    //Jbutton
    private JButton createEvent;
    private JButton sellTickets;
    private JButton resetList;
    private JButton sortDate;
    private JButton sortProfit;
    private JButton searchEvent;
    private JButton list;
    //Jtextarea
    private JTextArea events;
    private JLabel numberEvents;
    //
    TRAPSCalendar calendar = new TRAPSCalendar();

    public static void main(String[] args) {
        new TRAPSGUIProject();
    }
    public TRAPSGUIProject(){
        WidgetViewer wv = new WidgetViewer();
        //adding a welcome message
        welcome = new JLabel("Welcome to Tabby Recreation and Party Service\n");
        wv.add(welcome, 10, 10, 300, 20);
        //-----------------------------------------------
        eventName = new JLabel("Event Name");
        name = new JTextField(1);
        wv.add(eventName, 10, 30, 150, 20);
        wv.add(name, 120, 30, 300, 20);
        //-----------------------------------------------
        eventVenue = new JLabel("Event Venue");
        venue = new JTextField(1);
        wv.add(eventVenue, 10, 50, 150, 20);
        wv.add(venue, 120, 50, 300, 20);
        //-----------------------------------------------
        venueCapacity = new JLabel("Venue Capacity");
        capacity = new JTextField(1);
        wv.add(venueCapacity, 10, 70, 150, 20);
        wv.add(capacity, 120, 70, 300, 20);
        //-----------------------------------------------
        eventDate = new JLabel("Event Date");
        date = new JTextField(1);
        wv.add(eventDate, 10, 90, 150, 20);
        wv.add(date, 120, 90, 300, 20);
        //-----------------------------------------------
        ticketsSold = new JLabel("Tickets Sold");
        tSold = new JTextField(1);
        wv.add(ticketsSold, 10, 110, 150, 20);
        wv.add(tSold, 120, 110, 300, 20);
        //-----------------------------------------------
        tickePrice = new JLabel("Ticket Price");
        tprice = new JTextField(1);
        wv.add(tickePrice, 10, 130, 150, 20);
        wv.add(tprice, 120, 130, 300, 20);
        //-----------------------------------------------
        overheadCost = new JLabel("Overhead Costs");
        overhead = new JTextField(1);
        wv.add(overheadCost, 10, 150, 150, 20);
        wv.add(overhead, 120, 150, 300, 20);

        //----------JButtons------------
        createEvent = new JButton("Create an Event");
        wv.add(createEvent, 10, 180, 200, 20);
        ButtonAddEvent action = new ButtonAddEvent(createEvent);
        createEvent.addActionListener(action);

        sellTickets = new JButton("Sell Tickets");
        wv.add(sellTickets, 220, 180, 200, 20);
        sellTickets.addActionListener(new ButtonAddEvent(sellTickets));

        resetList = new JButton("Reset List");
        wv.add(resetList, 10, 200, 200, 20);
        resetList.addActionListener(new ButtonAddEvent(resetList));

        sortDate = new JButton("Sort by Date");
        wv.add(sortDate, 220, 200, 200, 20);
        sortDate.addActionListener(new ButtonAddEvent(sortDate));

        sortProfit = new JButton("Sort by Profit");
        wv.add(sortProfit, 10,220 , 200, 20);
        sortProfit.addActionListener(new ButtonAddEvent(sortProfit));

        //change action buttom
        searchEvent = new JButton("Search by Name");
        wv.add(searchEvent, 220, 220, 200,20);
        //07.20.20 add action
        searchEvent.addActionListener(new ButtonAddEvent(searchEvent));


        eventListLabel = new JLabel("List of Events");
        wv.add(eventListLabel,10, 240,150,25);
        numberEvents = new JLabel("Number of Events so far");
        wv.add(numberEvents,220,240,300,25);

        events = new JTextArea("");
        wv.add(events,10,260,700,250);

        //-----------------------------------------------

    }
    class ButtonAddEvent extends WidgetViewerActionEvent{
        private JButton myButton;
        public ButtonAddEvent(JButton buttonToModify){
            myButton = buttonToModify;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            //create event works
            if(myButton.getText().equals("Create an Event")){
                Event event = new Event(name.getText(),venue.getText(),Integer.parseInt(capacity.getText())
                        ,date.getText(), Integer.parseInt(tSold.getText()),
                        Integer.parseInt(tprice.getText()),Integer.parseInt(overhead.getText()));
                calendar.add(event);
                name.setText("");
                venue.setText("");
                //07.20.20 added capacity
                capacity.setText("");
                date.setText("");
                tSold.setText("");
                tprice.setText("");
                //07.20.20 set Text for overhead bc it was missing before
                overhead.setText("");
                events.setText(events.getText() + calendar.toString());
                numberEvents.setText("Number of Events so far " + calendar.size());

            }
            //works
            else if(myButton.getText().equals("Sell Tickets")) {
                String names = name.getText();
                int index = 0;
                for (int i = 0; i < calendar.size(); i++) {
                    String temp = calendar.get(i).getEventName();
                    if (names.equalsIgnoreCase(temp)) {
                        index = i;
                    }
                }
                calendar.get(index).setTicketsSold(calendar.get(index).getTicketsSold() + Integer.parseInt(tSold.getText()));
                events.setText("");
                for (int i = 0; i< calendar.size(); i++){
                    events.setText(events.getText() + calendar.get(i).toString());
                }
            }
           //reset list actually resets the listing
            /*else if(myButton.getText().equals("Reset List")){
                events.setText("");
                for (int i = 0; i < calendar.size(); i++) {
                    events.setText(events.getText() + calendar.get(i).toString());
                    numberEvents.setText("Number of Events so far 0");
                    events.setText("");
                }
            }*/
            else if(myButton.getText().equals("Reset List")){
                events.setText("");
                    events.setText(events.getText() + calendar.list());
            }

            //works
            else if(myButton.getText().equals("Sort by Date")){
                    events.setText(calendar.sortByDate().toString());
            }
            //works
            else if(myButton.getText().equals("Sort by Profit")){
                events.setText(calendar.sortByProfit().toString());
            }
            //07.20.20 Search by Name finds an event from the calendar by that name
            // if there's multiple with the same name it gives the first one
            //if nothing is found then the program says that no events were found
            else if (myButton.getText().equals("Search by Name")){{}
                String searchName = name.getText();

                for (int i = 0; i < calendar.size(); i++) {
                    String temp = calendar.get(i).getEventName();
                    if(searchName.equalsIgnoreCase(temp)) {
                    events.setText("The first event with the name " +searchName + "was found" + "\n" + calendar.get(i).toString());
                        numberEvents.setText("Number of Events so far " + calendar.size());
                    }else {
                        events.setText(searchName + "was not found " +
                                "\n Or ERROR YOU PRESSED RESET LIST AND ADDED A NEW EVENT " +
                                "WHICH WILL BE THE ONLY ONE THAT CAN SEARCHED FOR");
                        numberEvents.setText("Number of Events so far " + calendar.size() + "-1");
                    }
                }

            }

        }
    }
}
