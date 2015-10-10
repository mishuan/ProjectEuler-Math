import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 * Design:
 * - Scanner takes in user input
 * - calls crawler method to get date/version pairs
 * - runs binary search with user input date against crawler tuple
 * <p>
 * Assumptions:
 * - Tuple is ordered (we can just sort if it's not)
 * - Tuple is sanitized and massaged to an ImmutablePair
 * - long: date in milliseconds
 * - string: content of web page at given date
 * - content is just a string for simplicity
 * - mock getContent method that returns tuple of versions given a website
 * - due to time constraints, assume user input is valid
 * <p>
 * Input:
 * - Website: String
 * - Date: MM/DD/YYYY
 */
public class WaybackMachine {
  // duration of a day in milliseconds
  static long MAGIC_CONSTANT = 86400000l;
  static long TODAY = new GregorianCalendar(2015, 10, 10).getTimeInMillis();
  static boolean TEST = true;

  static void run(Scanner in) {
    String website = in.nextLine();
    String[] dateString = in.nextLine().split("/");
    long dateInMilli = new GregorianCalendar(Integer.valueOf(dateString[2]),
        Integer.valueOf(dateString[0]),
        Integer.valueOf(dateString[1])).getTimeInMillis();
    List<ImmutablePair> versions = getContent(website);
    int idx = modifiedBinarySearch(versions, dateInMilli);
    if (idx != -1)
      System.out.println("input date: " + dateInMilli
          + "; found date: " + versions.get(idx).getLeft()
          + "; content: " + versions.get(idx).getRight());
    else
      System.out.println("Website did not exist at the date inputted.");
  }

  static int modifiedBinarySearch(List<ImmutablePair> list, long date) {
    int i = 0;
    int lo = 0;
    int hi = list.size() - 1;
    while (lo <= hi) {
      i = lo + (hi - lo) / 2;
      if (date > (long) list.get(i).getLeft()) lo = i + 1;
      else if (date < (long) list.get(i).getLeft()) hi = i - 1;
      else return i;
    }
    if (i == 0 && (long) list.get(i).getLeft() > date) return -1;
    return (long) list.get(i).getLeft() > date ? i : i + 1;
  }

  public static void main(String[] args) {
    if (!TEST) {
      Scanner in = new Scanner(System.in);
      run(in);
      in.close();
    } else {
      // oct 15, 2015
      List<ImmutablePair> list = getContent("blur");
      for (ImmutablePair pair : list) System.out.println(pair.toString());
      run(new Scanner("tripadvisor.com\n10/10/2015"));
      run(new Scanner("tripadvisor.com\n10/15/2015"));
      run(new Scanner("tripadvisor.com\n10/18/2015"));
      run(new Scanner("tripadvisor.com\n10/10/2000"));
    }
  }

  static List<ImmutablePair> getContent(String website) {
    // mock data
    List<ImmutablePair> versions = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      ImmutablePair<Long, String> pair = new ImmutablePair<>(TODAY + i * 7 * MAGIC_CONSTANT, "version" + i);
      versions.add(pair);
    }
    return versions;
  }
}

