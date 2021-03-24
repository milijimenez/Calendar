import java.util.ArrayList;
import java.util.Scanner;

public class SCalendarTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("How many events will you enter? ");
        int numstr = sc.nextInt();
        SCalendar tc= new SCalendar();
        System.out.println("Enter event name " + (i +1)+ ":");
        String name = sc.nextLine();
        System.out.print("Enter event venue " + (i +1)+ ":");
        String venue = sc.nextLine();
        while (tc.add(new Event(name, venue)) && i < numstr-1){
            i++;
            System.out.println("Enter event name " + (i +1)+ ":");
            name = sc.nextLine();
            System.out.println("Enter event venue " + (i +1)+ ":");
            venue = sc.nextLine();
        }

        //seems to not store the object
        System.out.println("Number of events " + tc.size());
        System.out.println("List of events " + tc.list());
        System.out.println("Search for an event");
        String n = sc.next();
        System.out.println("Event was found" + tc.get(n));
        System.out.println("Search for an event number");
        int numevent = sc.nextInt();
        System.out.println("The event that is number" + numevent + " is " + tc.get(numevent));
    }


}
