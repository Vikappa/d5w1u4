package Classes;

import java.util.Scanner;

public class PlayerEngine {

    private Media[] fileStorage;

    public PlayerEngine(){
        Media[] files = new Media[5];
        this.fileStorage = files;
    }

    private void addMediaToStorage(Media target){
        for (int i = this.fileStorage.length-1; i > 0 ; i--) {
            this.fileStorage[i] = this.fileStorage[i-1];
        }
        fileStorage[0] = target;
        System.out.println("File added to storage");
    }

    private void createMedia(Scanner scanner) {
        int action = 0; //
        while (action < 1 || action > 3) {
            System.out.println("Adding new media, please choose file type");
            System.out.println("1: Picture");
            System.out.println("2: Track");
            System.out.println("3: Movie");
            System.out.print("Please type a number between 1 to 3 then press ENTER: ");

            if (scanner.hasNextInt()) {
                action = scanner.nextInt();
                scanner.nextLine();
                switch (action) {
                    case 1:
                        System.out.println("Please insert picture description.");
                        String picTitle = scanner.nextLine();
                        Picture newPic = new Picture(picTitle);
                        addMediaToStorage(newPic);
                        start();
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
                        addMediaToStorage(newtrack);
                        start();
                        break;
                    case 3:
                        System.out.println("Please insert movie title.");
                        String movieTitle = scanner.nextLine();
                        System.out.println("Please insert movie frames.");
                        int frames = -1;
                        while (frames < 0) {
                            if (scanner.hasNextInt()) {
                                frames = scanner.nextInt();
                                scanner.nextLine();

                                if (frames < 0) {
                                    System.out.println("Please insert a positive number for the duration.");
                                }
                            } else {
                                System.out.println("Invalid input. Please insert an integer for the duration.");
                                scanner.next();
                            }
                        }
                        Movie newMobie = new Movie(movieTitle, frames);
                        addMediaToStorage(newMobie);
                        start();
                        break;
                    default:
                        System.out.println("Invalid command. Please type a number between 0 to 2.");
                        action = 0; // Ritorna nel loop che si ripete finchè action è diverso da 1 2 3
                        break;
                }
            } else {
                System.out.println("Invalid command. Please type a number between 0 to 2.");
                scanner.next(); // Consuma caratteri residui per pulire il prossimo scan
            }
        }
    }

    private void browseMedia(Scanner lettore){

        for (int i = 0; i < fileStorage.length; i++) {
            if(fileStorage[i] != null){
                System.out.println((i+1) + "-" + fileStorage[i].getTitle());
            }
        }


        int chosenFileIndex = -1;
        while (chosenFileIndex < 0 || chosenFileIndex > 5){
            System.out.println("Please chose a file to play or type 0 to exit");
            if(lettore.hasNextInt()){
                chosenFileIndex = lettore.nextInt();
                lettore.nextLine(); // This consumes the newline character after the number
                if(chosenFileIndex < 0 || chosenFileIndex > 5){
                    System.out.println("Please select a valid file number between 1 to 5 or type 0 to exit.");
                } else if (chosenFileIndex == 0) {
                    start();
                    break;
                } else {
                    this.fileStorage[chosenFileIndex-1].run();
                }
            }else{
                System.out.println("Invalid input. Please enter a number.");
                lettore.next();
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
                    browseMedia(scanner);
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
