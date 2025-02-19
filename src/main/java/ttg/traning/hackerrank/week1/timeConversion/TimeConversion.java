package ttg.traning.hackerrank.week1.timeConversion;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ttg
 */
public class TimeConversion {

    public static String process(String timeIn12Format) {
        String hourIn12Format = timeIn12Format.substring(0, timeIn12Format.indexOf(":"));
        String hourIn24Format;
        boolean isTimeAM = timeIn12Format.contains("AM");
        if (isTimeAM) {
            hourIn24Format = hourIn12Format.equals("12") ? "00" : hourIn12Format;
        } else {
            hourIn24Format = hourIn12Format.equals("12") ? "12" : String.format("%02d", Integer.parseInt(hourIn12Format) + 12);
        }
        return timeIn12Format
                .replaceFirst(hourIn12Format, hourIn24Format)
                .replace("AM","")
                .replace("PM","");
    }

    public static String process1(String timeIn12Format) {
        // Extract hour, minute, second, and period (AM/PM)
        String hourIn12Format = timeIn12Format.substring(0, 2);
        String minuteAndSeconds = timeIn12Format.substring(2, timeIn12Format.length() - 2);
        boolean isAM = timeIn12Format.endsWith("AM");

        // Convert to 24-hour format
        int hour = Integer.parseInt(hourIn12Format);
        String hourIn24Format;
        if (isAM) {
            hourIn24Format = (hour == 12) ? "00" : String.format("%02d", hour);
        } else {
            hourIn24Format = (hour == 12) ? "12" : String.format("%02d", hour + 12);
        }

        // Reconstruct the final string
        return hourIn24Format + minuteAndSeconds;
    }

    public static String process2(String timeIn12Format) {
        // Define input (12-hour) and output (24-hour) format
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("hh:mm:ssa");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Parse and format
        LocalTime time = LocalTime.parse(timeIn12Format, inputFormat);
        return time.format(outputFormat);
    }
}
