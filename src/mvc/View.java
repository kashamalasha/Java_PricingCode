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
     * Главное меню программы
     */
    void showMainMenu() {
        this.clearScreen();
        System.out.println();
        System.out.println("  <=               Меню               =>  ");
        System.out.println("  --------------------------------------  ");
        System.out.println();
        System.out.println("  1 = Рассчитать код ");
        System.out.println("  0 = Завершить работу ");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("  --------------------------------------  ");
          System.out.print("  Command => ");
    }

    /**
     * Ввод данных для расчета кода
     * @param data номер строки 1 - номер подразделения, 2 - дата
     * @see Controller#setData()
     */
    void showDataAsk(int data, int DepNo) {
        switch (data) {
            case 1:
                this.clearScreen();
                System.out.println();
                System.out.println("  <=     Ввод данных для расчета      =>  ");
                System.out.println("  --------------------------------------  ");
                System.out.println();
                System.out.println("  1: Номер магазина в системе NQ: ");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("  --------------------------------------  ");
                  System.out.print("  Command => ");
                break;
            case 2:
                this.clearScreen();
                System.out.println();
                System.out.println("  <=     Ввод данных для расчета      =>  ");
                System.out.println("  --------------------------------------  ");
                System.out.println();
                System.out.println("  1: Номер магазина в системе NQ: " + DepNo);
                System.out.println("  2: Дата в формате DDMMYY: ");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("  --------------------------------------  ");
                  System.out.print("  Command => ");
                break;
        }
    }

    /**
     * Вывод результатов расчета кода
     * @param result Строка с кодом авторизации
     * @see Controller#run()
     */
    void showResult(String result){
        this.clearScreen();
        System.out.println();
        System.out.println("  <=          Код авторизации         =>  ");
        System.out.println("  --------------------------------------  ");
        System.out.println();
        System.out.println("             >>  "+ result +"  << ");
        System.out.println();
        System.out.println("  1 = Скопировать в буфер ");
        System.out.println("  2 = Повторить расчет ");
        System.out.println("  0 = Завершить ");
        System.out.println();
        System.out.println("  --------------------------------------  ");
          System.out.print("  Command => ");
    }

    /**
     * Очистка экрана терминала
     * WINDOWS: cmd -> cls
     * UNIX: ANSI ESCAPE SYMBOLS:
     *   ANSI_CLS = "\u001b[2J"
     *   ANSI_HOME = "\u001b[H"
     */
    void clearScreen() {
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
