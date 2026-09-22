import java.util.Scanner;

public class DaysOfMonth {

    // Danh sách các định dạng hợp lệ cho từng tháng (từ tháng 1 đến 12)
    private static final String[][] VALID_MONTHS = {
        {"1", "january", "jan.", "jan"},
        {"2", "february", "feb.", "feb"},
        {"3", "march", "mar.", "mar"},
        {"4", "april", "apr.", "apr"},
        {"5", "may", "may.", "may"},
        {"6", "june", "june.", "jun"},
        {"7", "july", "july.", "jul"},
        {"8", "august", "aug.", "aug"},
        {"9", "september", "sept.", "sep"},
        {"10", "october", "oct.", "oct"},
        {"11", "november", "nov.", "nov"},
        {"12", "december", "dec.", "dec"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int month = -1;
        int year = -1;

        // Vòng lặp yêu cầu nhập tháng hợp lệ
        while (month == -1) {
            System.out.print("Enter month (e.g., January, Jan., Jan, or 1): ");
            String inputMonth = scanner.nextLine().trim();
            month = parseMonth(inputMonth);

            if (month == -1) {
                System.out.println("Invalid month! Please enter again.\n");
            }
        }

        // Vòng lặp yêu cầu nhập năm hợp lệ (số nguyên không âm và đủ chữ số)
        while (year == -1) {
            System.out.print("Enter year (non-negative integer, e.g., 2024): ");
            String inputYear = scanner.nextLine().trim();

            if (inputYear.matches("^\\d+$")) {
                try {
                    int parsedYear = Integer.parseInt(inputYear);
                    if (parsedYear >= 0) {
                        year = parsedYear;
                    } else {
                        System.out.println("Invalid year! Year must be non-negative.\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid year! Number is too large.\n");
                }
            } else {
                System.out.println("Invalid year format! Please enter full numeric digits.\n");
            }
        }

        // Tính số ngày
        int days = getNumberOfDays(month, year);
        boolean isLeap = isLeapYear(year);

        System.out.println("----------------------------------------");
        System.out.printf("Month: %d | Year: %d (%s year)\n", month, year, isLeap ? "Leap" : "Common");
        System.out.printf("Number of days: %d\n", days);

        scanner.close();
    }

    // Chuyển chuỗi nhập vào thành giá trị tháng (1 - 12), trả về -1 nếu không hợp lệ
    private static int parseMonth(String input) {
        String normalized = input.toLowerCase();

        for (int i = 0; i < VALID_MONTHS.length; i++) {
            for (String alias : VALID_MONTHS[i]) {
                if (alias.equals(normalized)) {
                    return i + 1; // Tháng 1 -> 12
                }
            }
        }
        return -1;
    }

    // Kiểm tra năm nhuận
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Lấy số ngày tương ứng với từng tháng
    private static int getNumberOfDays(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }
}