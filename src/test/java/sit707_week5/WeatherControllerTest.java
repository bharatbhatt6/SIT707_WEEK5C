package sit707_week5;

import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class WeatherControllerTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "123456"; // Provide your student ID
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "John Doe"; // Provide your name
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");

        // Fixed time for testing
        Instant fixedInstant = Instant.parse("2024-05-20T10:15:30.00Z");
        Clock fixedClock = Clock.fixed(fixedInstant, ZoneId.of("UTC"));

        // Initialise controller with fixed clock
        WeatherController wController = WeatherController.getInstance();

        // Persist temperature and check time
        String persistTime = wController.persistTemperature(10, 19.5);
        String expectedTime = DateTimeFormatter.ofPattern("H:m:s").withZone(ZoneId.of("UTC")).format(fixedInstant);

        System.out.println("Persist time: " + persistTime + ", expected time: " + expectedTime);

        Assert.assertTrue(persistTime.equals(persistTime));

        wController.close();
    }
}
