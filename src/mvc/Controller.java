package mvc;

import java.util.InputMismatchException;
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

    //TODO: Private String calcCode() {}

    /**
     * Алгорит работы приложения
     * @see View#showResult(String) :
     */
    public void run() {
        int select = 0;
        switch (this.getMenuItem()) {
            case 1:
                this.setData();
                //TODO String result = this.calcCode(model.getDate, model.getDepNo)
                //Заглушка
                String testResult = "" + model.getDate() + ":" + model.getDepNo();
                while (select == 0) {
                    view.showResult(testResult);
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
