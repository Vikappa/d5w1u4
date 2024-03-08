package Classes;

public interface AudioContent extends Media {

    int volume = 5;

    void play();

    void run();

    public void increaseVolume(int amount);

    public void decreaseVolume(int amount);

}
