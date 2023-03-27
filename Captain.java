

public class Captain {
//-----------------------------------------------------
// Title: Captain Class
// Author: Azerhan BAĞCI
// Description: This class stores data to be accessed later.
//-----------------------------------------------------
    private String name;
    private boolean available = true;
    private int ratingstar = 0;

    public Captain() {}

    public Captain(String name, boolean available, int ratingstar) {
        this.name = name;
        this.available = available;
        this.ratingstar = ratingstar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getRatingstar() {
        return ratingstar;
    }

    public void setRatingstar(int ratingstar) {
        this.ratingstar = ratingstar;
    }

    public String toString() {
        //--------------------------------------------------------
        // Summary: Returns information as String.
        // Precondition: this is not null
        // Postcondition: Information returned as String.
        //--------------------------------------------------------
        return "Name: " + name + "\n" + "Available: " + available + "\n" + "Rating star: " + ratingstar;
    }
}
