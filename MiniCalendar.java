import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MiniCalendar {

    public static void printMonth(int year, int month) {
        // Array of month names
        String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        // Days in each month
        int[] daysInMonth = {
            0, 31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        // Check for leap year
        if (month == 2 && isLeapYear(year)) {
            daysInMonth[2] = 29;
        }

        // Print heading
        System.out.println("   " + months[month] + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        // Get the start day of the month
        Calendar cal = new GregorianCalendar(year, month - 1, 1);
        int startDay = cal.get(Calendar.DAY_OF_WEEK);

        // Print leading spaces
        for (int i = 1; i < startDay; i++) {
            System.out.print("   ");
        }

        // Print days of the month
        for (int day = 1; day <= daysInMonth[month]; day++) {
            System.out.printf("%2d ", day);

            // Go to next line after Saturday
            if ((day + startDay - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter year (e.g. 2025): ");
        int year = sc.nextInt();

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Invalid month!");
            return;
        }

        printMonth(year, month);
    }
}
