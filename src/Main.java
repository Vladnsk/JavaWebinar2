import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Владислав on 29.07.2017.
 */

public class Main {

    public void stringTest(String text){
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        builder.append(text); // добавить готовую строку
        String completedString = builder.toString(); // результирующая строка
        System.out.println("Введенная строка: " + builder);
        System.out.println("Длина этой строки: " + builder.length());
        System.out.println("ВЫделено память под эту строку: " + builder.capacity());
        System.out.println("Введите новую длину строки, больше 0");
        int newLength = scanner.nextInt();
        scanner.nextLine();
        builder.setLength(newLength);
        System.out.println("Новая строка, с учётом вашей длины(" + newLength +  "): " + builder);
        System.out.println("Введите индекс символа для замены");
        int index = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Это символ: " + builder.charAt(index));
        System.out.println("Меняем на символ (введите новый символ): ");
        String newText = scanner.nextLine();
        char symbol = newText.charAt(0);
        builder.setCharAt(index,symbol);
        System.out.println("Новая строка: " + builder);
        builder.reverse();
        System.out.println("Реверс строки: " + builder);
        System.out.println("Введите индекс символа для удаления: ");
        int indexDel = scanner.nextInt();
        scanner.nextLine();
        builder.deleteCharAt(indexDel);
        System.out.println("Новая строка: " + builder);
        System.out.println("Сейчас произведем удаление нескольких символов");
        System.out.println("Введите индекс первого символа для удаления: ");
        int indexDelStart = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите индекс последнего символа для удаления: ");
        int indexDelEnd = scanner.nextInt();
        scanner.nextLine();
        builder.delete(indexDelStart, indexDelEnd);
        System.out.println("Новая строка: " + builder);
        System.out.println("Сейчас произведем замену нескольких символов");
        System.out.println("Введите строку для замены: ");
        String newTextR = scanner.nextLine();
        int strRLength = newTextR.length();
        System.out.println("Введите индекс первого символа для замены: ");
        int indexReplaceStart = scanner.nextInt();
        scanner.nextLine();
        builder.replace(indexReplaceStart,indexReplaceStart + strRLength,newTextR);
        System.out.println("Новая строка: " + builder);
        System.out.println("Введите индекс с которого необходимо вывести символы: ");
        int indexLast = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Результат работы программы: " + builder.substring(indexLast));
    }

    public void onlyOne(String text){
        Pattern pat=Pattern.compile("[1]");
        Matcher matcher=pat.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        };
    }

    public static void main(String[] args){
        Main main = new Main();
        main.stringTest("abcd abcd1111 QWERTY");
        main.onlyOne("12133321-ааы233-131111111-3dsqdl");
    }
}
