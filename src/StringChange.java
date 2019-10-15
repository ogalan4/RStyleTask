import java.io.*;

// Способ 1 - с помощью BufferedReader и PrintWriter
public class StringChange {
    public static void main(String[] args) {
        File file = new File("in.txt");                     // Создаем обьект Файл, и заносим туда путь
        try {                                                        // Создаем обьект Бафферет-ридера и Принт-райтера и заносим их
            BufferedReader br = new BufferedReader(new FileReader(file));       // в try With resourses
            PrintWriter print = new PrintWriter(new FileWriter("out.txt", false));

            String vord1 = "Васей.";        //Создаем переменные с искомыми и заменяемыми словами.
            String vord2 = "Петей.";        // Комбинаций будет 2 поскольку в исходном файле слово Вася используется в 2х падежах
            String vord3 = "Вася";
            String vord4 = "Петя";
            String res = "";                //Создаем переменную, в которую будем записывать резалт-строку
            String temp = br.readLine();    //Считываем строку из файла
            String[] words = temp.split(" ");       // Делим строку на слова и заносим их в массив стрингов
            for (int i = 0; i < words.length; i++) {        //Создаем цыкл и в нем перебираем все слова, и в случае совпадения
                if (words[i].equals(vord1)) {                       // с искомыми словами - заменяем их;
                    words[i] = vord2;
                }
                if (words[i].equals(vord3)) {
                    words[i] = vord4;
                }
                res += " " + words[i];                              //Записываем слова в переменную итоговой строки
            }
            print.println(res);                         //Записываем итоговую строку в файл
            print.flush();                              //Флашим поток
        } catch (FileNotFoundException e) {             //Обрабатываем исключения
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// Способ 2 - с помощью Scanner
//import java.io.*;
//        import java.nio.file.Files;
//        import java.nio.file.Path;
//        import java.nio.file.Paths;
//        import java.util.Collections;
//        import java.util.Scanner;

//public class NameConvertor {
//    public static void main(String[] args) throws IOException {
//        String filepath = "in.txt";         //Записываем в переменную путь к файлу
//        File file = new File(filepath);     //Создаем обьект Файла и кладем в него путь.
//
//        String vord1 = "Васей.";        //Создаем переменные с искомыми и заменяемыми словами.
//        String vord2 = "Петей.";        // Комбинаций будет 2 поскольку в исходном файле слово Вася используется в 2х падежах
//        String vord3 = "Вася";
//        String vord4 = "Петя";
//        Scanner sc = new Scanner(file); // Создаем обьект Сканера, и помещаем туда файл
//        String text = sc.nextLine();    // Считываем строку из файла
//        String res = "";                // Создаем строковую переменную для исходной строки.
//        String[] words = text.split(" ");   //Делим строку на слова, и записываем в массив строк
//
//        for (int i = 0; i < words.length; i++) {        //Создаем цыкл и в нем перебираем все слова, и в случае совпадения
//            if (words[i].equals(vord1)) {                       // с искомыми словами - заменяем их;
//                words[i] = vord2;
//            }
//            if (words[i].equals(vord3)) {
//                words[i] = vord4;
//            }
//            res += " " + words[i];                              //Записываем слова в переменную итоговой строки
//
//        }
//        Files.write(Paths.get("in.txt"), Collections.singleton(res));       //Записываем переменную в исходный файл
//    }
//}
// Можно реализовать посимвольный перебор, но это будет издевательство над кодом, программистом, и Java))))))