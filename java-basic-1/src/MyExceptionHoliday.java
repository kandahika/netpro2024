import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class MyExceptionHoliday {
    public static void main(String[] args) {
        MyExceptionHoliday myExceptionHoliday = new MyExceptionHoliday();
        myExceptionHoliday.run();
    }

    void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (true) {
            try {
                System.out.println("2024年5月の何日ですか? (終了するには 'quit' を入力)");
                line = reader.readLine();
                if ("quit".equalsIgnoreCase(line)) break;

                int day = Integer.parseInt(line);
                if (day < 1 || day > 31) {
                    System.out.println("1から31の間で入力してください。");
                    continue;
                }

                testDay(day);
            } catch (IOException e) {
                System.out.println("入力エラーが発生しました: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("数値の形式が正しくありません。");
            } catch (NoHolidayException e) {
                e.printStackTrace();
            }
        }
    }

    void testDay(int day) throws NoHolidayException {
        LocalDate date = LocalDate.of(2024, 5, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        boolean isHoliday = isHoliday(day, dayOfWeek);

        if (!isHoliday) {
            throw new NoHolidayException();
        } else {
            System.out.println("日付 " + day + " は " + dayOfWeek + " で、休日です。");
        }
    }

    boolean isHoliday(int day, DayOfWeek dayOfWeek) {
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return true;
        }

        switch (day) {
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
        }

        return false;
    }
}
