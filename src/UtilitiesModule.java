import java.util.*;

public class UtilitiesModule {
    public static boolean isUniqueParam(List<String> l) {
        Set<String> s = new HashSet<String>(l);
        if (s.size() < l.size()) {
            return false;
        }
        return true;
    }

    public static int randomAnyStep(int b) {
        Random r = new Random();
        return r.nextInt(b + 1);
    }

    public static String isWin(int u, int c, List<String> l) {
        int p = (l.size() - 1) / 2;
        String w = null;
        if (u == c) {
            w = "Ничья!";
            return w;
        }
        if (u >= p) {
            List<String> loseList = l.subList(u - p, u);
            if (loseList.indexOf(l.get(c)) == -1) w = "Компьютер";
            else w = "Пользователь";
        } else if (u < p) {
            List<String> winList = l.subList(u, u + p);
            if (winList.indexOf(l.get(c)) == -1) w = "Пользователь";
            else w = "Компьютер";
        }
        return w;
    }
}
