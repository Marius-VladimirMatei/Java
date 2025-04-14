// Class designed to calculate the work duration between two date-times

import java.time.*;
import java.time.temporal.ChronoUnit;

public class WorkTimeCalculator {
    // Any hours outside of this range are not counted as work hours
    private static final LocalTime WORK_START = LocalTime.of(8, 0);
    private static final LocalTime WORK_END = LocalTime.of(16, 0);

    public Duration calculateWorkDuration(LocalDateTime start, LocalDateTime end) {
        long totalSeconds = 0; // initialize total seconds to 0

        // Set the start and end times for day by day calculation
        LocalDate currentDate = start.toLocalDate();
        LocalDate endDate = end.toLocalDate();

        // Loop through each day starting from the 'currentDate' until the 'endDate'
        while (!currentDate.isAfter(endDate)) {

            // For the current day, set the start and end times of the work period
            LocalDateTime dayStart = LocalDateTime.of(currentDate, WORK_START);
            LocalDateTime dayEnd = LocalDateTime.of(currentDate, WORK_END);

            // Determine the actual start time for the day
            LocalDateTime actualStart;

            // Check if the provided start time is on the current day and later than the standard work start
            if (start.toLocalDate().equals(currentDate) && start.isAfter(dayStart)) {
                actualStart = start;  // Use the provided start time
            } else {
                actualStart = dayStart;  // Otherwise, default to the official work start time
            }

            // Determine the actual end time for the day
            LocalDateTime actualEnd;

            // Check if the provided end time is on the current day and before the standard work end
            if (end.toLocalDate().equals(currentDate) && end.isBefore(dayEnd)) {
                actualEnd = end;  // Use the provided end time
            } else {
                actualEnd = dayEnd;  // Otherwise, default to the official work end time
            }

            // Check if the actual start time comes before the actual end time
            if (!actualStart.isAfter(actualEnd)) {
                // Calculate the number of seconds between actualStart and actualEnd using ChronoUnit.SECONDS.between
                long seconds = ChronoUnit.SECONDS.between(actualStart, actualEnd);
                // Add these seconds to the totalSeconds accumulator
                totalSeconds += seconds;
            }

            // Move to the next day by adding one day to currentDate
            currentDate = currentDate.plusDays(1);
        }


        return Duration.ofSeconds(totalSeconds);
    }
}





/*
while (!currentDate.isAfter(endDate)) { // Loop through each day from start to end date
            LocalDateTime dayStart = LocalDateTime.of(currentDate, WORK_START);
            LocalDateTime dayEnd = LocalDateTime.of(currentDate, WORK_END);

            LocalDateTime actualStart = start.isAfter(dayStart) && start.toLocalDate().equals(currentDate) ? start
                    : dayStart;
            LocalDateTime actualEnd = end.isBefore(dayEnd) && end.toLocalDate().equals(currentDate) ? end : dayEnd;

            if (!actualStart.isAfter(actualEnd)) {
                // Replace Duration.between(...) with manual second difference
                long seconds = ChronoUnit.SECONDS.between(actualStart, actualEnd);
                totalSeconds += seconds;
            }

            currentDate = currentDate.plusDays(1);
        }

 */