import Classes.Audio;
import Classes.Movie;
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

        fotoLili.increaseBrightness(3);
        fotoPazu.decreaseBrightness(4);

        fotoPazu.run();
        fotoLili.run();

        System.out.println("-------------------------------------------------------------------------------------------");

        Movie pazuzuVideo = new Movie("Pazuzu che dorme", 10);

        pazuzuVideo.play();

        Audio rammSong = new Audio("Dicke Titten - Rammstein", 22);

        rammSong.play();

    }
}