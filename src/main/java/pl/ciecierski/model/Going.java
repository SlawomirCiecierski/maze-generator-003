package pl.ciecierski.model;

import java.util.List;

public class Going {

   private List<Coordinates> going;

    private Going() {

    }

    public Going(List<Coordinates> going) {
        this.going = going;
    }

    public List<Coordinates> getGoing() {
        return going;
    }

    public void setGoing(List<Coordinates> going) {
        this.going = going;
    }
}
