import java.util.Scanner;

public class CreditCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите сумму: ");
        double summ = sc.nextDouble();
        System.out.println("Введите срок: ");
        int period = sc.nextInt();
        System.out.println("Введите желаемый процент годовых: ");
        double percent = sc.nextDouble();
        System.out.println("Кредит с желаемыми параметрами: ");
        Credit credit = new Credit(summ, percent, period);
        System.out.println(credit.contract());
        credit.realContract();
        System.out.println("Рассрочка с желаемыми параметрами: ");
        Credit installmentPlan = new Credit(summ, period);
        System.out.println(installmentPlan.contract());
        installmentPlan.realContract();
    }
}
