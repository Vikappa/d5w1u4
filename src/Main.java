import Classes.Audio;
import Classes.Movie;
import Classes.Picture;
import Classes.PlayerEngine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

    System.out.println("Application started");
    PlayerEngine player = new PlayerEngine();
    player.start();

    }
}