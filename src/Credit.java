import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Credit {
    double summ; // сумма кредита
    double percent; // процент кредита в год
    int period; // срок в месяцах

    public Credit(double summ, int period) { // конструктор для рассрочки
        this.summ = summ;
        this.percent = 0;
        this.period = period;
    }

    public Credit(double summ, double percent, int period) { // конструктор для кредита
        this(summ, period);
        this.percent = percent;
    }

    public String payment() { // платёж в месяц
        return ". Платёж в месяц составит: " + rounding(((summ * percent / 100) + summ) / period);
    }

    public String overpayment() { // переплата за весь срок кредита
        return ". Переплата составит: " + rounding(summ * percent / 100);
    }

    public StringBuilder contract() { // методБ создающий договор
        StringBuilder contract = new StringBuilder("Уважаемый клиент, мы выдаём вам заём на сумму ");
        contract.append(summ);
        contract.append(payment());
        contract.append(".  Переплата будет очень незначительной.");
        return contract;
    }
    public void realContract() { // метод, исправляющий договор
        System.out.println("Честный договор: ");
        StringBuilder str = contract();
        Pattern pattern = Pattern.compile(". Переплата");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()) {
            int start = matcher.start() - 1;
            int end = str.length();
            str.delete(start,end);
        }
        str.append(overpayment());
        System.out.println(str);
    }
    public static double rounding (double number) { // метод, округляющий значения платежа
        number*= 100;
        number = Math.round(number);
        number/= 100;
        return number;

    }
}

