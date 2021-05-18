import java.util.Scanner;

public class BursdagsKalkulator {

    public static void main(String[] args) {

        //Spør brukeren om informasjon
        Scanner sc = new Scanner(System.in);
        System.out.println("What date of the month were you born?: ");
        int day = sc.nextInt();
        System.out.println("What month were you born?: ");
        String month = sc.next();
        month = month.toLowerCase();
        System.out.println("What year were you born?: ");
        int year = sc.nextInt();

        //Finner tallet for måneden
        int nMonth = monthNumber(month);
        //Finner tallet for tiåret
        int decade = decadeNumber(year);
        //Finner siste tall i fødselsåret
        int lastNumberOfYear = year % 10;
        //Finner tallet for skuddår
        int leapYear = leapYear(year, lastNumberOfYear);

        String weekDay = dayOfWeek(day, nMonth, decade, lastNumberOfYear, leapYear);
        System.out.println("You were born on a " + weekDay);
    }

    //Finner hvilket tall måneden er
    public static int monthNumber(String month) {
        int nMonth = 0;
        switch (month) {
            case "january":
                nMonth = 6;
                break;
            case "febuary":
                nMonth = 2;
                break;
            case "march":
                nMonth = 2;
                break;
            case "april":
                nMonth = 5;
                break;
            case "may":
                nMonth = 0;
                break;
            case "june":
                nMonth = 3;
                break;
            case "july":
                nMonth = 5;
                break;
            case "august":
                nMonth = 1;
                break;
            case "september":
                nMonth = 4;
                break;
            case "october":
                nMonth = 6;
                break;
            case "november":
                nMonth = 2;
                break;
            case "december":
                nMonth = 4;
            default:
                System.out.println("Invalid input");
        }
        return nMonth;
    }

    //Finner hvilket tall tiåret er
    public static int decadeNumber(int year) {
        int decade = 0;
        if (year >= 1900 && year < 1910) {
            decade = 1;
        } else if (year >= 1910 && year < 1920) {
            decade = 6;
        } else if (year >= 1920 && year < 1930) {
            decade = 5;
        } else if (year >= 1930 && year < 1940) {
            decade = 3;
        } else if (year >= 1940 && year < 1950) {
            decade = 2;
        } else if (year >= 1950 && year < 1960) {
            decade = 0;
        } else if (year >= 1960 && year < 1970) {
            decade = 6;
        } else if (year >= 1970 && year < 1980) {
            decade = 4;
        } else if (year >= 1980 && year < 1990) {
            decade = 3;
        } else if (year >= 1990 && year < 2000) {
            decade = 1;
        } else if (year >= 2000 && year < 2010) {
            decade = 0;
        } else if (year >= 2010 && year < 2020) {
            decade = 5;
        }
        return decade;
    }

    //Finner tallet for skuddår
    public static int leapYear(int year, int lastNumberOfYear) {
        int decade = year-lastNumberOfYear;
        int leapYear = 0;
        if (decade==0) {
            switch (lastNumberOfYear) {
                case 0: case 1: case 2: case 3:
                    leapYear = 0;
                    break;
                case 4: case 5: case 6: case 7:
                    leapYear = 1;
                    break;
                case 8: case 9:
                    leapYear = 2;
                    break;
            }
        }else {
            switch (lastNumberOfYear) {
                case 0: case 1:
                    leapYear = 0;
                    break;
                case 2: case 3: case 4: case 5:
                    leapYear = 1;
                    break;
                case 6: case 7: case 8: case 9:
                    leapYear = 2;
                    break;
            }
        }
        return leapYear;
    }

    //Regner ut hvilken dag
    public static String dayOfWeek(int day, int month, int decade, int nYear, int leapYear) {

        int nWeek = (day + month + decade + nYear + leapYear) % 7;

        String dayOfWeek = null;
        switch (nWeek) {
            case 1: {
                dayOfWeek = "Monday";
                break;
            }
            case 2: {
                dayOfWeek = "Tuesday";
                break;
            }
            case 3: {
                dayOfWeek = "Wednesday";
                break;
            }
            case 4: {
                dayOfWeek = "Thursday";
                break;
            }
            case 5: {
                dayOfWeek = "Friday";
                break;
            }
            case 6: {
                dayOfWeek = "Saturday";
                break;
            }
            case 0: {
                dayOfWeek = "Sunday";
                break;
            }
        }
        return dayOfWeek;
    }
}
