import java.text.*;
import java.util.*;

public class Teste {

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");
        formatter.setLenient(false);

        String endTime = "25.06.2017, 15:05:36";

        Date endDate;
        long milliseconds = 0;
        try {
            endDate = formatter.parse(endTime);
            milliseconds = endDate.getTime();

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        long startTime = System.currentTimeMillis();

        long diff = milliseconds - startTime;

        CountDownTimer mCountDownTimer = new CountDownTimer(milliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                startTime = startTime - 1;
                Long serverUptimeSeconds
                        = (millisUntilFinished - startTime) / 1000;

                String daysLeft = String.format("%d", serverUptimeSeconds / 86400);
                txtViewDays.setText(daysLeft);

                String hoursLeft = String.format("%d", (serverUptimeSeconds % 86400) / 3600);
                txtViewHours.setText(hoursLeft);

                String minutesLeft = String.format("%d", ((serverUptimeSeconds % 86400) % 3600) / 60);

                txtViewMinutes.setText(minutesLeft);

                String secondsLeft = String.format("%d", ((serverUptimeSeconds % 86400) % 3600) % 60);
                txtViewSecond.setText(secondsLeft);

            }

            @Override
            public void onFinish() {
                // This method is intentionally left empty because no action is required when the countdown finishes.
            }
        }.start();

    }
}
