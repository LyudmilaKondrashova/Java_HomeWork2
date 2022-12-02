import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("5. Замените символ “=” на слово “равно”. Используйте методы " +
                "StringBuilder.insert(),StringBuilder.deleteCharAt().");
        System.out.print("Введите строку: ");
        String string6 = scan.nextLine();
        System.out.println("Преобразованная строка: " + replace1(string6));
        System.out.println("*************************************************************");

        System.out.println("6. Замените символ “=” на слово “равно”. Используйте методы " +
                "StringBuilder.replace().");
        System.out.print("Введите строку: ");
        String string7 = scan.nextLine();
        System.out.println("Преобразованная строка: " + replace2(string7));
        System.out.println("*************************************************************");

        System.out.println("1. Напишите программу, чтобы найти наименьшее окно в строке, " +
                "содержащей все символы другой строки.");
        System.out.print("Введите строку: ");
        String string1 = scan.nextLine();
        System.out.print("Введите подстроку: ");
        String string2 = scan.nextLine();
        findMinWindow(string1, string2);
        System.out.println("*************************************************************");

        System.out.println("2. Напишите программу, чтобы проверить, являются ли две данные " +
                "строки вращением друг друга.");
        System.out.print("Введите первую строку: ");
        String string3 = scan.nextLine();
        System.out.print("Введите вторвую строку: ");
        String string4 = scan.nextLine();
        rotation(string3, string4);
        System.out.println("*************************************************************");

        System.out.println("3. Напишите программу, чтобы перевернуть строку с помощью рекурсии.");
        System.out.print("Введите строку: ");
        String string5 = scan.nextLine();
        System.out.println("Перевернутая строка: " + rotationRec(string5));
        System.out.println("*************************************************************");

        System.out.println("4. Дано два числа, например 3 и 56, необходимо составить " +
                "следующие строки:\n" +
                "3 + 56 = 59 3 – 56 = -53 3 * 56 = 168. Используем метод StringBuilder.append().");
        System.out.print("Введите первое число: ");
        int number1 = scan.nextInt();
        System.out.print("Введите второе число: ");
        int number2 = scan.nextInt();
        System.out.println(newStringNumber(number1, number2));
        System.out.println("*************************************************************");

        System.out.println("7. Сравнить время выполнения пунка 6 со строкой содержащей " +
                "10000 символов средствами String и StringBuilder.");
        System.out.println("Ожидайте.......");
        comparison();
    }

    //1. Напишите программу, чтобы найти наименьшее окно в строке, содержащей все
    // символы другой строки.
    public static void findMinWindow(String str, String subStr) {
        String minStr = "";
        if (subStr.length() > str.length()) {
            System.out.println("Строка короче, чем подстрока. Программа закончила свою работу");
        } else {
            int indStart = str.indexOf(subStr);
            if (indStart != -1) {
                minStr = str.substring(0, indStart);
                int indEnd = indStart + subStr.length();
                str = str.substring(indEnd, str.length());
                indStart = str.indexOf(subStr);
                while (indStart != -1) {
                    if ((minStr.length() == 0 && indStart > 0) || (minStr.length() > indStart)) {
                        minStr = str.substring(0, indStart);
                    }
                    indEnd = indStart + subStr.length();
                    str = str.substring(indEnd, str.length());
                    indStart = str.indexOf(subStr);
                }
                if (minStr.length() == 0) {
                    System.out.println("Наименьшая подстрока пустая!");
                } else {
                    System.out.println("Наименьшее окно: " + minStr);
                }
            } else {
                System.out.println("Строка не содержит подстроку");
            }
        }
    }

    //2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга.
    public static void rotation(String str1, String str2) {
        StringBuilder strb = new StringBuilder(str2);
        if (str1.equals(strb.reverse().toString())) {
            System.out.println("Строки являются вращением друг друга");
        } else {
            System.out.println("Строки не являются вращением друг друга");
        }
    }

    //3. Напишите программу, чтобы перевернуть строку с помощью рекурсии.
    public static String rotationRec(String str) {
        int leng = str.length();
        if (leng == 0) {
            return "";
        }
        return str.charAt(leng - 1) + rotationRec(str.substring(0, leng - 1));
    }

    //4. Дано два числа, например 3 и 56, необходимо составить следующие строки:
    // 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168. Используем метод StringBuilder.append().
    public static StringBuilder newStringNumber(int numb1, int numb2) {
        StringBuilder strb1 = new StringBuilder();
        int newNumb = numb1 + numb2;
        if (numb2 < 0) {
            strb1.append(numb1 + " + (" + numb2 + ") = " + newNumb + "  ");
        } else {
            strb1.append(numb1 + " + " + numb2 + " = " + newNumb + "  ");
        }
        newNumb = numb1 - numb2;
        if (numb2 < 0) {
            strb1.append(numb1 + " - (" + numb2 + ") = " + newNumb + "  ");
        } else {
            strb1.append(numb1 + " - " + numb2 + " = " + newNumb + "  ");
        }
        newNumb = numb1 * numb2;
        if (numb2 < 0) {
            strb1.append(numb1 + " * (" + numb2 + ") = " + newNumb + "  ");
        } else {
            strb1.append(numb1 + " * " + numb2 + " = " + newNumb + "  ");
        }
        return strb1;
    }

    //5. Замените символ “=” на слово “равно”. Используйте методы
    // StringBuilder.insert(),StringBuilder.deleteCharAt().
    public static String replace1(String str) {
        StringBuilder strb1 = new StringBuilder(str);
        for (int i = 0; i < strb1.length(); i++) {
            int ind = strb1.indexOf("=");
            if (ind != -1) {
                strb1.deleteCharAt(ind);
                strb1.insert(ind, "равно");
            }
        }
        return strb1.toString();
    }

    //6. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
    public static String replace2(String str) {
        StringBuilder strb1 = new StringBuilder(str);
        int ind = strb1.indexOf("=");
        while (ind != -1) {
            strb1.replace(ind, ind + 1, "равно");
            ind = strb1.indexOf("=");
        }
        return strb1.toString();
    }

    //Замена символа “=” на слово “равно” с использованием String.
    public static String replace3(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.compare(str.charAt(i), '=') != 0) {
                newStr = newStr.concat(String.valueOf(str.charAt(i)));
            } else {
                newStr = newStr.concat("равно");
            }
        }
        return newStr;
    }

    //7. Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов
    // "=" средствами String и StringBuilder.
    public static void comparison() {
        StringBuilder strb1 = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            strb1.append("=");
        }
        long start = System.currentTimeMillis();
        String str = replace2(strb1.toString());
        System.out.println("Время выполнения средствами StringBuilder равно:");
        System.out.println(System.currentTimeMillis() - start + " миллисекунд");

        start = System.currentTimeMillis();
        str = replace3(strb1.toString());
        System.out.println("Время выполнения средствами String равно:");
        System.out.println(System.currentTimeMillis() - start + " миллисекунд");
    }
}