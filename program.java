import java.io.BufferedOutputStream;
// import java.io.File;
// import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

public class program {
    public static void main(String[] args) throws IOException {
        
        inputUser();
        createFile();
    }

    public static void inputUser(){
        try{
        System.out.println("Введите первый символ(c1): ");
        Scanner c1Scanner = new Scanner(System.in);
        String c1 = c1Scanner.next();
        System.out.println("Введите второй символ(c2): ");
        Scanner c2Scanner = new Scanner(System.in);
        String c2 = c2Scanner.next();
        System.out.println("Введите длину строки(N): ");
        Scanner NScanner = new Scanner(System.in);
        int N = NScanner.nextInt();

        c1Scanner.close();
        c2Scanner.close();
        NScanner.close();

        printString(c1, c2, N);

        } catch (InputMismatchException exc) {
            System.out.println("Что вы там в консоль ввели ?");
        }

    }

    public static void printString(String c1, String c2, int N) {
        String stroka = new String(c1 + c2); 
        String result = ""; 
        if (N > 0 && N % 2 == 0 && stroka.length() == 2){
            for (int i = 0; i < N/2; i++) {
                // System.out.printf(stroka);
                result += stroka;
            }
            System.out.println("Результат: " + result);
        } else {
            if (N <= 0) {
                System.out.println("Длина строки должна быть больше 0 ! А вы ввели " + N);
            }
            if (N % 2 == 1) {
                System.out.println("Длина строки должна быть четной! Разве " + N + " чётное число ?");
            }
            if (stroka.length() != 2) {
                System.out.println("всего должно быть 2 символа а у вас: " + stroka.length());
            }
        }
    }

    public static void createFile() throws IOException {
        BufferedOutputStream crFile = new BufferedOutputStream(new FileOutputStream("file.txt"));
        String text = "TEXT";
        int stringLength = 100;
        for (int i = 0; i < stringLength; i++) {
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            crFile.write(bytes);
            crFile.flush();
        }
        System.out.println("А ещё записал слово TEXT 100 раз, посмотрите файл 'file.txt'");
        crFile.close();

    }
}

    // 1 Дано четное число N (> 0) и символы c1 и c2. Написать метод, 
    // который вернет строку длины N, которая состоит из чередующихся символов c1 и c2, 
    // начиная с c1. (6, 'a', 'b') -> "ababab"
    // 2 Создать файл с названием file.txt. Если файл уже есть, 
    // то создавать не надо Записать в него Слово "TEXT" 100 раз
 
