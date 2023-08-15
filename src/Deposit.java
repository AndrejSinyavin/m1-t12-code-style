import java.util.Scanner;

public class Deposit {
    double calculateComplexPercent(double initialDepositAmount, double year, int day) {
        double pay = initialDepositAmount * Math.pow((1 + year / 12), 12 * day);
        return generateRandomDouble(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return generateRandomDouble(amount + amount * yearRate * depositPeriod, 2);
    }

    double generateRandomDouble(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int period;
        int action;
        double expectedIncome = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            expectedIncome = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            expectedIncome = calculateComplexPercent(amount, 0.06, period);
        } else {
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + expectedIncome);
    }

    public static void main(String[] args) {
        new Deposit().calculateDeposit();
    }
}
