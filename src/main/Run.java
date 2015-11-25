package main;

import mvc.Controller;
import mvc.Model;
import mvc.View;

/**
 * Main class
 */
public class Run {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller ctrl = new Controller(view, model);

        ctrl.run();
    }
}
