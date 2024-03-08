package Classes;

import java.util.Scanner;

public class PlayerEngine {

    private Media[] fileStorage;

    public PlayerEngine(){
        Media[] files = new Media[5];
        this.fileStorage = files;
    }

    private void createMedia(Scanner scanner) {
        int action = -1; //
        while (action < 0 || action > 2) {
            System.out.println("Adding new media, please choose file type");
            System.out.println("1: Picture");
            System.out.println("2: Track");
            System.out.println("0: Movie");
            System.out.print("Please type a number between 0 to 2 then press ENTER: ");

            if (scanner.hasNextInt()) {
                action = scanner.nextInt();
                scanner.nextLine();
                switch (action) {
                    case 1:
                        System.out.println("Please insert picture description.");
                        String picTitle = scanner.nextLine();
                        Picture newPic = new Picture(picTitle);
                        newPic.run();
                        break;
                    case 2:
                        System.out.println("Please insert track title.");
                        String trackTitle = scanner.nextLine();
                        System.out.println("Please insert track duration.");
                        int duration = -1;
                        while (duration < 0) {
                            if (scanner.hasNextInt()) {
                                duration = scanner.nextInt();
                                scanner.nextLine();

                                if (duration < 0) {
                                    System.out.println("Please insert a positive number for the duration.");
                                }
                            } else {
                                System.out.println("Invalid input. Please insert an integer for the duration.");
                                scanner.next();
                            }
                        }
                        Audio newtrack = new Audio(trackTitle, duration);
                        newtrack.run();
                        break;
                    case 0:
                        System.out.println("Please insert movie title.");
                        String movieTitle = scanner.nextLine();
                        Picture newMobie = new Picture(movieTitle);
                        newMobie.run();
                        break;
                    default:
                        System.out.println("Invalid command. Please type a number between 0 to 2.");
                        action = -1; // Ritorna nel loop
                        break;
                }
            } else {
                System.out.println("Invalid command. Please type a number between 0 to 2.");
                scanner.next(); // Consuma caratteri residui per pulire il prossimo scan
            }
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Chose an option:");
            System.out.println("1: Add a new media");
            System.out.println("2: Browse");
            System.out.println("0: Exit");
            System.out.print("Type an option between 0 and 2 then press ENTER: ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    createMedia(scanner);
                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("Shutting down..");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input, try again.");
            }
        }
    }
}
