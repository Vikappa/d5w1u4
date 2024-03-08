package Classes;

public class Movie implements VideoContent, AudioContent{

    int brightNess = 5;
    int volume = 5;

    @Override
    public void play() {

    }

    @Override
    public void run() {
        this.play();
    }

    @Override
    public void increaseVolume(int amount) {

    }

    @Override
    public void decreaseVolume(int amount) {

    }

    @Override
    public void show() {

    }

    @Override
    public void increaseBrightness(int amount) {

    }

    @Override
    public void decreaseBrightness(int amount) {

    }
}
