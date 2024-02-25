import java.time.LocalDateTime;

public class BirthdayChecker {

    public boolean isBirthDay() {
        LocalDateTime today = LocalDateTime.now();
        return today.getDayOfMonth() == 1 && today.getMonthValue() == 1;
    }
}
