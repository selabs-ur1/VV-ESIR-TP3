package fr.istic.vv;

class Date implements Comparable<Date> {

  private int day;
  private int month;
  private int year;

  public Date(int day, int month, int year) throws Exception {
    if (!isValidDate(day, month, year)) {
      throw new Exception("Invalid date");
    }
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public static boolean isValidDate(int day, int month, int year) {
    boolean isValidYear = year != 0; // Year 0 does not exists, according to historians
                                     // (https://fr.wikipedia.org/wiki/Year_Zero)
    boolean isValidMonth = month >= 1 && month <= 12;

    boolean isValidDate31Days = day >= 1 && day <= 31
        && (month == 1 || month == 3 || month == 5 || month == 7
            || month == 8 || month == 10 || month == 12);

    boolean isValidDate30Days = day >= 1 && day <= 30
        && (month == 4 || month == 6 || month == 9 || month == 11);
    boolean isValidDateFebruary = day >= 1 &&
        (day <= 28 && !isLeapYear(year) || day <= 29 && isLeapYear(year))
        && month == 2;

    boolean isValidDate = isValidDate31Days || isValidDate30Days || isValidDateFebruary;

    return isValidYear && isValidMonth && isValidDate;
  }

  public static boolean isLeapYear(int year) {
    return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
  }

  public Date nextDate() throws Exception {
    int newDay = this.day + 1;
    int newMonth = this.month;
    int newYear = this.year;
    if (!isValidDate(newDay, newMonth, newYear)) {
      newDay = 1;
      newMonth += 1;
      if (!isValidDate(newDay, newMonth, newYear)) {
        newMonth = 1;
        newYear += 1;
        if (newYear == 0) {
          newYear += 1;
        }
      }
    }
    return new Date(newDay, newMonth, newYear);
  }

  public Date previousDate() throws Exception {
    int newDay = this.day - 1;
    int newMonth = this.month;
    int newYear = this.year;
    if (!isValidDate(newDay, newMonth, newYear)) {
      newMonth -= 1;
      if (newMonth == 4 || newMonth == 6 || newMonth == 9 || newMonth == 11) {
        newDay = 30;
      } else if (newMonth == 1 || newMonth == 3 || newMonth == 5 || newMonth == 7
          || newMonth == 8 || newMonth == 10) {
        newDay = 31;
      } else if (newMonth == 2) {
        if (isLeapYear(newYear)) {
          newDay = 29;
        } else {
          newDay = 28;
        }
      }
      if (!isValidDate(newDay, newMonth, newYear)) {
        newMonth = 12;
        newYear -= 1;
        newDay = 31;
        if (newYear == 0) {
          newYear -= 1;
        }
      }
    }
    return new Date(newDay, newMonth, newYear);
  }

  public int compareTo(Date other) {
    if (this.day == other.day && this.month == other.month && this.year == other.year) {
      return 0;
    } else if (this.day <= other.day && this.month <= other.month && this.year <= other.year) {
      return 1;
    } else {
      return -1;
    }
  }
}