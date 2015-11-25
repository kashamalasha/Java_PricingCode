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
    public void showMainMenu() {
        this.clearScreen();
        System.out.println();
        System.out.println("  <=   Меню  =>  ");
        System.out.println("  -------------  ");
        System.out.println("  1 = Генерация  ");
        System.out.println("  2 = Выход      ");
        System.out.println("  -------------  ");
          System.out.print("  Command => ");
    }

    /**
     * Ввод данных для расчета кода
     * @param data номер строки 1 - номер подразделения, 2 - дата
     * @see Controller#setData()
     */
    public void showDataAsk(int data) {
        switch (data) {
            case 1:
                this.clearScreen();
                System.out.println();
                System.out.println("  <=       Данные для расчета     =>  ");
                System.out.println("  ----------------------------------  ");
                  System.out.print("  Номер магазина в системе NQ: ");
                break;
            case 2:
                  System.out.print("  Дата в формате DDMMYY: ");
                break;
        }
    }

    /**
     * Вывод результатов расчета кода
     * @param result Строка с кодом авторизации
     * @see Controller#run()
     */
    public void showResult(String result){
        this.clearScreen();
        System.out.println();
        System.out.println("  <=        Код авторизации       =>  ");
        System.out.println("  ----------------------------------  ");
        System.out.println("  " + result);
        System.out.println("  ----------------------------------  ");
        System.out.println("  Нажмите: 1 - Повторить | 2 - Выйти  ");
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
