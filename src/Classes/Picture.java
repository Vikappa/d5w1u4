package Classes;

public class Picture implements VideoContent {
    private final String title;
    private int brightNess;

    public Picture(String name){
        this.title = name;
        this.brightNess = 5;
    }

    @Override
    public void run() {
        this.show();
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void show() {
        System.out.print("Showing picture " + this.title + " BRIGHNTESS: ");
        for (int i = 0; i < brightNess; i++) {
            System.out.print("*");
        }
        System.out.println();
    }


    public int getBrightNess() {
        return brightNess;
    }

    private void setBrightNess(int brightNess) {
        this.brightNess = brightNess;
    }

    @Override
    public void increaseBrightness(int amount) {
        if(this.brightNess + amount <= 10) {
            setBrightNess(this.brightNess + amount);
        } else {
            System.out.println("Maximum brightness exceeded. Set to 10");
            this.setBrightNess(10);
        }
    }

    @Override
    public void decreaseBrightness(int amount) {
        if(this.brightNess - amount >= 0){
            setBrightNess(this.getBrightNess()-amount);
        } else {
            System.out.println("Minimum brightness exceeded. Set to 0");
            this.setBrightNess(0);
        }
    }
}
