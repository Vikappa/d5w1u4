package Classes;

public class Movie implements VideoContent, AudioContent {

    private int brightNess;
    private int volume;
    private final int duration;
    private final String title;


    public Movie(String title, int duration){
        this.brightNess = 5;
        this.volume = 5;
        this.title= title;
        this.duration = duration;
    }

    @Override
    public void play() {
        for (int i = 0; i <= duration; i++) {
            System.out.print("Now playing movie: " + this.title + " Frame " + i + "/" + this.duration + " VOLUME: ");
            for (int j = 0; j < this.volume; j++) {
                System.out.print("*");
            }

            System.out.print(", BRIGHTNESS ");
            for (int j = 0; j < this.brightNess; j++) {
                System.out.print("*");
            }
            System.out.println();
            try {
                Thread.sleep(100); // Attende un decimo di secondo
            } catch (InterruptedException e) {
                // Catch obbligato
                Thread.currentThread().interrupt();
                System.out.println("The execution was stopped");
            }
        }
    }

    @Override
    public void run() {
        this.play();
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    public int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void increaseVolume(int amount) {
        if (this.volume + amount <= 10) {
            setVolume(this.brightNess + amount);
        } else {
            System.out.println("Maximum volume exceeded. Set to 10");
            this.setVolume(10);
        }
    }

    @Override
    public void decreaseVolume(int amount) {
        if (this.volume - amount >= 10) {
            setVolume(this.volume - amount);
        } else {
            System.out.println("Minimum volume exceeded. Set to 0");
            this.setVolume(0);
        }
    }

    @Override
    public void show() {
        this.play();
    }

    @Override
    public void increaseBrightness(int amount) {
        if (this.brightNess + amount <= 10) {
            setBrightNess(this.brightNess + amount);
        } else {
            System.out.println("Maximum brightness exceeded. Set to 10");
            this.setBrightNess(10);
        }
    }

    @Override
    public void decreaseBrightness(int amount) {
        if (this.brightNess - amount >= 0) {
            setBrightNess(this.getBrightNess() - amount);
        } else {
            System.out.println("Minimum brightness exceeded. Set to 0");
            this.setBrightNess(0);
        }
    }

    public int getBrightNess() {
        return brightNess;
    }

    private void setBrightNess(int brightNess) {
        this.brightNess = brightNess;
    }
}
