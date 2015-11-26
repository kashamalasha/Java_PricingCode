package main;

import mvc.Controller;
import mvc.Model;
import mvc.View;

/**
 * Исполняемый класс
 */
public class Run {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller ctrl = new Controller(view, model);

        ctrl.run();
    }
}
