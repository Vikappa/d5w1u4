package Classes;

public interface AudioContent extends Media {

    void play();

    void run();

    public void increaseVolume(int amount);

    public void decreaseVolume(int amount);

}
