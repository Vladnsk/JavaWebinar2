import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Владислав on 29.07.2017.
 */

public class Main {
    /*
    * 1. Внутри класса Solution создать public static классы Cat, Dog.
    * 2. Реализовать метод createCats, который должен возвращать множество с 4 котами.
    * 3. Реализовать метод createDogs, который должен возвращать множество с 3 собаками.
    * 4. Реализовать метод join, который должен возвращать объединенное множество всех
    * животных - всех котов и собак.
    * 5. Реализовать метод removeCats, который должен удалять из множества pets всех котов,
    * которые есть в множестве cats.
    * 6. Реализовать метод printPets, который должен выводить на экран всех животных, которые в нем есть.
    * Каждое животное с новой строки
     */
    public static class Cat{

    }

    public static class Dog{

    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();

        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());

        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> result = new HashSet<Dog>();

        result.add(new Dog());
        result.add(new Dog());
        result.add(new Dog());

        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        HashSet result = new HashSet();
        result.addAll(cats);
        result.addAll(dogs);

        return result;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {

        pets.removeAll(cats);

    }

    public static void printPets(Set<Object> pets) {
        Iterator iterator = pets.iterator();
        while (iterator.hasNext()){
            Object pet = iterator.next();
            System.out.println(pet);
        }
    }

    /*
    * Создание и вывод HashMap
     */

    public void hMap(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("Sim", 5);
        map.put("Tom", 5.5);
        map.put("Arbus", false);
        map.put("Baby", null);
        map.put("Cat", "Cat");
        map.put("Eat", new Long(56));
        map.put("Food", new Character('3'));
        map.put("Gevey", '6');
        map.put("Hugs", 111111111111L);
        map.put("Comp", (double) 123);

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> pair = iterator.next();
            String key = pair.getKey();
            Object value = pair.getValue();
            System.out.println(key + " - " + value);
        }
    }

    /*
    Измерить, сколько времени занимает 10 тысяч вызовов get для каждого списка.
    Метод getTimeMsOfGet должен вернуть время своего исполнения в миллисекундах.
     */

    public static List fill(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(new Object());
        }
        return list;
    }

    public static long getTimeMsOfGet(List list) {

        Date start = new Date();

        get10000(list);
        Date end = new Date();
        long res = end.getTime() - start.getTime();
        return res;

    }

    public static void get10000(List list) {
        if (list.isEmpty()) return;
        int x = list.size() / 2;

        for (int i = 0; i < 10000; i++) {
            list.get(x);
        }
    }

    /*
    * Задачи на строки StringBuilder
    *
    */

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

    /*
    * Задачи на регулярные выражения
    *
    */

    public void onlyOne(String text){
        Pattern pat=Pattern.compile("[1]");
        Matcher matcher=pat.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        };
    }

    /*
    * Ввести с клавиатуры 2 числа N и M.
    * Ввести N строк и заполнить ими список.
    * Переставить M первых строк в конец списка.
    *
    */
    public void arrayList() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> List = new ArrayList<String>();
        String buf = "";
        System.out.println("Введите 2 числа: \n 1 - количество строк \n 2 - сколько строк перенести в конец");
        buf = reader.readLine();
        int N = Integer.parseInt(buf);
        buf = reader.readLine();
        int M = Integer.parseInt(buf);
        System.out.println("Строки: ");
        for(int i = 0; i < N; i++){
            List.add(reader.readLine());
        }

        for(int i = 0; i < M; i++){
            String bufer = List.get(0);
            List.add(bufer);
            List.remove(0);
        }
        System.out.println("Результат: ");
        for(int j = 0; j < List.size(); j++){
            System.out.println(List.get(j));
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        //StringBuilder
        main.stringTest("abcd abcd1111 QWERTY");
        //regex
        main.onlyOne("12133321-ааы233-131111111-3dsqdl");

        //Перенос строк в arraylist
        try {
            main.arrayList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //create and print HashMap
        main.hMap();
        //сколько времени занимает 10 тысяч вызовов get для ArrayList
        System.out.println(getTimeMsOfGet(fill(new ArrayList())));
        //сколько времени занимает 10 тысяч вызовов get для LinkedList
        System.out.println(getTimeMsOfGet(fill(new LinkedList())));

    }
}
