import Classes.Picture;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("Applicazione avviata.");

        Picture fotoPazu = new Picture("Pazuzu che guarda dalla finestra");
        Picture fotoLili = new Picture("Lilith che dorme");

        fotoPazu.run();
        fotoLili.show();

        fotoPazu.increaseBrightness(10);
        fotoLili.decreaseBrightness(10);

        fotoPazu.run();
        fotoLili.run();

    }
}