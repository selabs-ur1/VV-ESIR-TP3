package fr.istic.vv;


class Date implements Comparable<Date> {
    int d, m, y;

    public Date(int day, int month, int year) throws Exception{
        if (!isValidDate(day, month, year)) {
                throw new Exception("this date isn't valid");
        
        } 
        else {
            d = day;
            m = month;
            y = year;
        }
    }

    public static boolean isValidDate(int day, int month, int year) {
        boolean res = true;
        if (year < 0)
            res = false;
        if (month <= 0 || month > 12)
            res = false;
        if (day <= 0)
            res = false;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day > 31)
                res = false;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30)
                res = false;
        } else if (month == 2) {
            if (isLeapYear(year)) {
                if (day > 29)
                    res = false;
            } else {
                if (day > 28)
                    res = false;
            }
        }

        return res;
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }

    public Date nextDate() throws Exception{

        // dernier jour de mois 31 jours sauf decembre
        if (this.m == 1 || this.m == 3 || this.m == 5 || this.m == 7 || this.m == 8 || this.m == 10) {
            if (this.d == 31) {
                return new Date(1, this.m + 1, this.y);
            }
        }

        // dernier jour de decembre
        else if (this.m == 12) {
            if (this.d == 31) {
                return new Date(1, 1, this.y + 1);
            }
        }

        // dernier jour de mois 30 jours
        else if (this.m == 4 || this.m == 6 || this.m == 9 || this.m == 11) {
            if (this.d == 30) {
                return new Date(1, this.m + 1, this.y);
            }
        }

        // 28e ou 29e jour de fevrier
        else if (this.m == 2) {
            // si bissextile
            if (isLeapYear(this.y)) {
                if (this.d == 28) {
                    return new Date(29, 2, this.y);
                } else if (this.d == 29) {
                    return new Date(1, 3, this.y);
                }
            }
            // sinon
            else if (this.d == 28) {
                return new Date(1, 3, this.y);
            }
        }

        return new Date(this.d + 1, this.m, this.y);

    }

    public Date previousDate() throws Exception {
        

        if (this.d == 1) {
            // premier jour de mois 31 jours sauf janvier
            if (this.m == 5 || this.m == 7 || this.m == 8 || this.m == 10 || this.m == 12) {

                return new Date(30, this.m - 1, this.y);
            }

            // premier jour de janvier
            else if (this.m == 1) {
                return new Date(31, 12, this.y - 1);
            }

            // premier jour de mois 30 jours ou fevrier ou juillet
            else if (this.m == 2 || this.m == 4 || this.m == 6 || this.m == 8 || this.m == 9 || this.m == 11) {
                
                    return new Date(31, this.m-1, this.y);
                
            }

            // premier jour de mars
            if (this.m == 3) {
                // si bissextile
                if (isLeapYear(this.y)) {
                    return new Date(29, 2, this.y);
                } else {
                    return new Date(28, 2, this.y);
                }
            }
        }

        return new Date(this.d - 1, this.m, this.y);

    }

    public int compareTo(Date other) {
        if (other == null) {
            throw new NullPointerException("the other date to compare is null");
        }

        else if (this.y > other.y) {
            return 1;
        } else if (this.y < other.y) {
            return -1;
        }

        // si meme annee
        else {
            if (this.m > other.m) {
                return 1;
            } else if (this.m < other.m) {
                return -1;
            }

            // si meme mois
            else {
                if (this.d > other.d) {
                    return 1;
                } else if (this.d < other.d) {
                    return -1;
                }

                //si meme date jour pour jour
                else{
                    return 0;
                }

            }
        }

    }

}
