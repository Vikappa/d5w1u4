package Classes;


public class Audio implements AudioContent{

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
}
