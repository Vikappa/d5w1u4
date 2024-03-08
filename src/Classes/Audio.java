package Classes;


public class Audio implements AudioContent{

    int volume;
    final int duration;
    final String title;

    public Audio(String tt, int duration){
        this.volume = 5;
        this.title = tt;
        this.duration = duration;
    }

    @Override
    public void play() {
        for (int i = 0; i <= duration; i++) {
            System.out.print("Now playing audio: " + this.title + " Segment " + i + "/" + this.duration + " VOLUME: ");
            for (int j = 0; j < this.volume; j++) {
                System.out.print("*");
            }
            System.out.println();
            try {
                Thread.sleep(100); // Attende un decimo di secondo
            } catch (InterruptedException e) {
                // Catch obbligato per usare sleep
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

    @Override
    public void increaseVolume(int amount) {
        if (this.volume + amount <= 10) {
            setVolume(this.volume + amount);
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

    public int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }
}
