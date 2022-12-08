package views;

import controllers.FuramaController;
import exception.InvalidAgeException;

public class Main {
    public static void main(String[] args){
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
}