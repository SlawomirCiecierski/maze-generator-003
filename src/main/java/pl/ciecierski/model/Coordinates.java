package pl.ciecierski.model;

public class Coordinates {
    private int h, w;
    private Azimuth azimuth;

    public Coordinates(int h, int w, Azimuth a) {
        this.h = h;
        this.w = w;
        this.azimuth=a;
    }

    public Coordinates() { }

    public int getH() {
        return h;
    }
    public void setH(int h) {
        this.h = h;
    }
    public int getW() {
        return w;
    }
    public void setW(int w) {
        this.w = w;
    }

    public Azimuth getAzimuth() {
        return azimuth;
    }
    public void setAzimuth(Azimuth azimuth) {
        this.azimuth = azimuth;
    }
}
