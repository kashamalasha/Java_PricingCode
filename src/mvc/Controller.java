package mvc;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Логика программы
 */
public class Controller {
    //Атрибуты класса..
    private final View view;    /** Пользовательский интерфейс **/
    private final Model model;  /** Модель данных **/

    private Scanner sc = new Scanner(System.in);

    //Конструктор класса..
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    //Методы класса..
    /**
     * Выбор пункта в главном меню
     * @return выбор 1 или 2
     * @see View#showMainMenu()
     */
    private int getMenuItem() {
        int select = 0;
        view.showMainMenu();
        try {
            select = sc.nextInt();
        } catch (InputMismatchException e) {
            this.getMenuItem();
        }
        sc.nextLine();
        return select;
    }

    /**
     * Ввод данных для расчета кода
     * @see View#showDataAsk(int)
     * @see Model
     */
    private void setData() {
        view.showDataAsk(1);
        try {
            model.setDepNo(sc.nextInt());
        } catch (InputMismatchException e) {
            this.setData();
        }
        view.showDataAsk(2);
        try {
            model.setDate(sc.nextInt());
        } catch (InputMismatchException e) {
            this.setData();
        }
    }

    /**
     * Расчет кода авторизации
     * @param date дата ввода кода
     * @param depNo номер подразделения
     * @return сгенерированный код
     */
    private String calcCode(int date, int depNo) {
        String result;
        int iCRC;
        char[] sKey = new char[10];

        depNo += 1000;
        result = "" + depNo;
        result = result.substring(Math.max(0, result.length() - 3));
        result = date + result;

        iCRC = 0;
        for (int i = 0; i < 9; i++) {
            iCRC += Integer.parseInt(String.valueOf(result.charAt(i)));
        }
        iCRC = iCRC % 9;

        sKey[0] = Integer.toString(iCRC).charAt(0);
        sKey[1] = result.charAt(8);
        sKey[2] = result.charAt(3);
        sKey[3] = result.charAt(1);
        sKey[4] = result.charAt(6);
        sKey[5] = result.charAt(2);
        sKey[6] = result.charAt(5);
        sKey[7] = result.charAt(0);
        sKey[8] = result.charAt(4);
        sKey[9] = result.charAt(7);

        result = String.valueOf(sKey);

        for (int i = 0; i < iCRC; i++) {
            result = result.charAt(9) + result.substring(0, 9);
        }

        StringBuilder builder = new StringBuilder(result);
        for (int i = 1; i < 10; i++) {
            builder.setCharAt(i-1,
                    Integer.toString((Integer.parseInt(String.valueOf(result.charAt(i-1)))
                            + i) % 10 ).charAt(0));
        }
        result = builder.toString();

        int threshold = Integer.parseInt(String.valueOf(result.charAt(0)));
        for (int i = 0; i < threshold; i++) {
            result = result.charAt(9) + result.substring(0,9);
        }

        return result;
    }

    /**
     * Алгорит работы приложения
     * @see View#showResult(String) :
     */
    public void run() {
        int select = 0;
        switch (this.getMenuItem()) {
            case 1:
                this.setData();
                String result = this.calcCode(model.getDate(), model.getDepNo());
                while (select == 0) {
                    view.showResult(result);
                    try {
                        select = sc.nextInt();
                    } catch (Exception e) {
                        select = 0;
                    }
                    switch (select) {
                        case 1:
                            this.run();
                            break;
                        case 2:
                            System.exit(0);
                            break;
                        default:
                            select = 0;
                    }
                }
                break;
            case 2:
                System.exit(0);
                break;
            default:
                this.run();
        }
    }
}
