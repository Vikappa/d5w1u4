package Classes;

import java.util.Scanner;

public class PlayerEngine {

    private Media[] fileStorage;

    public PlayerEngine(){
        Media[] files = new Media[5];
        this.fileStorage = files;
    }

    private void audioFocus(Media target, Scanner lettore) {
        Audio focussed = (Audio) target;
        System.out.println("Select an option:");
        System.out.println("1-Play");
        System.out.println("2-Increase Volume");
        System.out.println("3-Decrease Volume");
        System.out.println("4-Back to main menu");

        int chosenIndex = -1;
        while (chosenIndex < 1 || chosenIndex > 4) {
            System.out.println("Please choose an option or type 4 to go back to the main menu.");
            if (lettore.hasNextInt()) {
                chosenIndex = lettore.nextInt();
                lettore.nextLine();
                if (chosenIndex < 1 || chosenIndex > 4) {
                    System.out.println("Please select number between 1 to 4.");
                } else {
                    switch (chosenIndex) {
                        case 1:
                            focussed.run();
                            break;
                        case 2:
                            System.out.print("Enter the amount to increase volume: ");
                            int volumeIncrease = lettore.nextInt();
                            lettore.nextLine();
                            focussed.increaseVolume(volumeIncrease);
                            break;
                        case 3:
                            System.out.print("Enter the amount to decrease volume: ");
                            int volumeDecrease = lettore.nextInt();
                            lettore.nextLine();
                            focussed.decreaseVolume(volumeDecrease);
                            break;
                        case 4:
                            start();
                            break;
                    }
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                lettore.next();
            }
        }
    }

    private void pictureFocus(Media target, Scanner lettore) {
        if (!(target instanceof Picture)) {
            System.out.println("The selected media is not a picture.");
            return;
        }
        Picture focussed = (Picture) target;
        System.out.println("Select an option:");
        System.out.println("1-Show");
        System.out.println("2-Increase Brightness");
        System.out.println("3-Decrease Brightness");
        System.out.println("4-Back to main menu");

        int chosenIndex = -1;
        while (chosenIndex < 1 || chosenIndex > 4) {
            System.out.println("Please choose an option or type 4 to go back to the main menu.");
            if (lettore.hasNextInt()) {
                chosenIndex = lettore.nextInt();
                lettore.nextLine();
                if (chosenIndex < 1 || chosenIndex > 4) {
                    System.out.println("Please select a valid option number between 1 to 4.");
                } else {
                    switch (chosenIndex) {
                        case 1:
                            focussed.run();
                            break;
                        case 2:
                            System.out.print("Enter the amount to increase brightness: ");
                            int increaseAmount = lettore.nextInt();
                            lettore.nextLine();
                            focussed.increaseBrightness(increaseAmount);
                            break;
                        case 3:
                            System.out.print("Enter the amount to decrease brightness: ");
                            int decreaseAmount = lettore.nextInt();
                            lettore.nextLine();
                            focussed.decreaseBrightness(decreaseAmount);
                            break;
                        case 4:
                            start();
                            break;
                    }
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                lettore.next();
            }
        }
    }

    private void movieFocus(Media target, Scanner lettore) {
        if (!(target instanceof Movie)) {
            System.out.println("The selected media is not a movie.");
            return;
        }
        Movie focussed = (Movie) target;
        System.out.println("Select an option:");
        System.out.println("1-Play");
        System.out.println("2-Increase Brightness");
        System.out.println("3-Decrease Brightness");
        System.out.println("4-Increase Volume");
        System.out.println("5-Decrease Volume");
        System.out.println("6-Back to main menu");
        System.out.println();

        int chosenIndex = -1;
        while (chosenIndex < 1 || chosenIndex > 6) {
            System.out.println("Please choose an option or type 6 to go back to the main menu.");
            if (lettore.hasNextInt()) {
                chosenIndex = lettore.nextInt();
                lettore.nextLine();
                if (chosenIndex < 1 || chosenIndex > 6) {
                    System.out.println("Please select a valid option number between 1 to 6.");
                } else {
                    switch (chosenIndex) {
                        case 1:
                            focussed.run();
                            break;
                        case 2:
                            System.out.print("Enter the amount to increase brightness: ");
                            int increaseAmount = lettore.nextInt();
                            lettore.nextLine();
                            focussed.increaseBrightness(increaseAmount);
                            break;
                        case 3:
                            System.out.print("Enter the amount to decrease brightness: ");
                            int decreaseAmount = lettore.nextInt();
                            lettore.nextLine();
                            focussed.decreaseBrightness(decreaseAmount);
                            break;
                        case 4:
                            System.out.print("Enter the amount to increase volume: ");
                            int volumeIncrease = lettore.nextInt();
                            lettore.nextLine();
                            focussed.increaseVolume(volumeIncrease);
                            break;
                        case 5:
                            System.out.print("Enter the amount to decrease volume: ");
                            int volumeDecrease = lettore.nextInt();
                            lettore.nextLine();
                            focussed.decreaseVolume(volumeDecrease);
                            break;
                        case 6:
                            start();
                            break;
                    }
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                lettore.next();
            }
        }
    }

    private void addMediaToStorage(Media target){
        for (int i = this.fileStorage.length-1; i > 0 ; i--) {
            this.fileStorage[i] = this.fileStorage[i-1];
        }
        fileStorage[0] = target;
        System.out.println("File added to storage");
    }

    private void fileFocus(Media target, Scanner lettore){
        System.out.println();
        System.out.println("File " +target.getTitle()+ " choosen. Please select an action");
        //CONTROLLA SE TARGET IMPLEMENTA L'INTERFACCIA AUDIOCONTENT, VIDEOCONTENT O ENTRAMBI
        if (target instanceof AudioContent && !(target instanceof VideoContent)) {
            audioFocus(target, lettore);
        }
        if (target instanceof VideoContent && !(target instanceof AudioContent)) {
            pictureFocus(target, lettore);
        }
        if (target instanceof AudioContent && target instanceof VideoContent) {
            movieFocus(target, lettore);
        }

    }

    private void createMedia(Scanner scanner) {
        int action = 0; //
        while (action < 1 || action > 3) {
            System.out.println("Adding new media, please choose file type");
            System.out.println("1: Picture");
            System.out.println("2: Track");
            System.out.println("3: Movie");
            System.out.print("Please type a number between 1 to 3 then press ENTER: ");
            System.out.println();


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
        System.out.println();

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
                    fileFocus(fileStorage[chosenFileIndex-1], lettore);
                }
            }else{
                System.out.println("Invalid input. Please enter a number.");
                lettore.next();
            }
        }


    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();

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
