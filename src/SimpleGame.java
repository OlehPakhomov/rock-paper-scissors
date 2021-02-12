import org.apache.commons.codec.binary.Hex;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SimpleGame {
    public static void main(String args[]) {

        int userStep = 0;
        int computerStep = 0;
        byte[] key = null;
        Scanner stepScanner = new Scanner (System.in);
        List<String> listSteps = Arrays.asList(args);

        if (listSteps.size() < 3 || listSteps.size() % 2 == 0) {
            System.out.println("Ошибка! Количество параметров должно быть равно трем или больше и быть нечётным!");
            return;
        } else if (UtilitiesModule.isUniqueParam(listSteps) == false) {
            System.out.println("Введенные параметры не являются уникальными!");
            return;
        }

        computerStep = UtilitiesModule.randomAnyStep(listSteps.size()-1);
        key = HmacModule.generateSecurityRandomKey();
        System.out.println("\nHMAC: " + HmacModule.calculateHmac256(key, listSteps.get(computerStep)));

        do {
            System.out.println("Выбери один из возможных ходов: ");
            for (int i = 0; i < listSteps.size(); i++) {
                System.out.println(i + " - " + listSteps.get(i));
            }
            System.out.print("Твой выбор:" + "\t");
            userStep = stepScanner.nextInt();
        } while (userStep < 0 || userStep >= args.length);

        System.out.println("Твой ход:" + "\t" + listSteps.get(userStep));
        System.out.println("Ход компьютера:" + "\t" + listSteps.get(computerStep));
        System.out.println("ПОБЕДИТЕЛЬ: " + "\t" + UtilitiesModule.isWin(userStep, computerStep, listSteps));
        System.out.println("Ключ HMAC: " + Hex.encodeHexString(key));
    }
}