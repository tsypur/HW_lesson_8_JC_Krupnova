public class DayTemp {
    String maxTemp;
    String minTemp;
    String date;

    @Override
    public String toString() {
        return  "["+ date + ", " + maxTemp + ". " + minTemp + "]";
    }
}
