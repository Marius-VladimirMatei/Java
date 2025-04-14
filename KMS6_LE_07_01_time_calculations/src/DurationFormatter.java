//Class designed to format the duration in hours and minutes
// long instead of int used because the duration can be very large

import java.time.Duration;

public class DurationFormatter {
    public String format(Duration duration) {
        long hours = duration.toHours(); // converts total duration into whole hours
        long minutes = duration.toMinutes() % 60; // converts total duration into whole minutes
        return hours + " hour(s) and " + minutes + " minute(s)";
    }
}
