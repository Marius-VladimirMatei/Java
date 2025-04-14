import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class OrderDeliveryCalculator {
    public long calculateDaysBetween(LocalDate orderDate, LocalDate deliveryDate) {
        return ChronoUnit.DAYS.between(orderDate, deliveryDate);
    }
}
