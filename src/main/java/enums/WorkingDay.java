package enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;

public enum WorkingDay {

    MONDAY("Monday", "from 8a.m. to 11p.m."),
    TUESDAY("Thuesday", "from 8a.m. to 11p.m."),
    WEDNESDAY("Wednesday", "from 8a.m. to 11p.m."),
    THURSDAY("Thursday", "from 8a.m. to 11p.m."),
    FRIDAY("Friday", "from 8a.m. to 8p.m.");
    private final static Logger LOGGER = LogManager.getLogger(WorkingDay.class);

    private String day;
    private String hour;

    WorkingDay(String day, String hour) {
        this.day = day;
        this.hour = hour;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String printCustom(Function<WorkingDay, String> f) {
        return f.apply(this);
    }
}
