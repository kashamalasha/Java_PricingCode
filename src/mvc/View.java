package mvc;

import java.io.IOException;

/**
 * Интерфейс взаимодействия с пользоватлем
 */
public class View {
    //Атрибуты класса..
    //Конструктор класса..

    //Методы класса..
    /**
     * Ввод данных для расчета кода
     * @see Controller#setData()
     */
    public void showDataAsk() {
        this.clearScreen();
        System.out.println();
        System.out.println("  <=    Выберите завод для расчета    =>  ");
        System.out.println("  --------------------------------------  ");
        System.out.println();
        System.out.println("  1: Завод 2295 ");
        System.out.println("  2: Завод 2361 ");
        System.out.println("  3: Завод 2370 ");
        System.out.println();
        System.out.println();
        System.out.println("  4: Завершить ");
        System.out.println("  --------------------------------------  ");
        System.out.println();
          System.out.print("  Command => ");
    }

    /**
     * Вывод результатов расчета кода
     * @param result Строка с кодом авторизации
     * @see Controller#run()
     */
    public void showResult(String result){
        this.clearScreen();
        System.out.println();
        System.out.println("  <=          Код  авторизации        =>  ");
        System.out.println("  --------------------------------------  ");
        System.out.println();
        System.out.println("             >>  "+ result +"  << ");
        System.out.println();
        System.out.println("  1: Скопировать в буфер ");
        System.out.println("  2: Повторить расчет ");
        System.out.println();
        System.out.println("  4: Завершить ");
        System.out.println("  --------------------------------------  ");
        System.out.println();
          System.out.print("  Command => ");
    }

    /**
     * Очистка экрана терминала
     * WINDOWS: cmd -> cls
     * UNIX: ANSI ESCAPE SYMBOLS:
     *   ANSI_CLS = "\u001b[2J"
     *   ANSI_HOME = "\u001b[H"
     */
    private void clearScreen() {
        final String OS = System.getProperty("os.name");
        if (OS.contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("\u001b[2J\u001b[H");
            System.out.flush();
        }
    }
}
