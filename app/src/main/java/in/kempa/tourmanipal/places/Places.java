package in.kempa.tourmanipal.places;

/**
 * Created by Ganesh Poojary on 11/6/2016.
 */

public class Places {
    int id;
    float ratings;
    String name;
    String description;

    public Places(int id, int ratings, String name, String description) {
        this.id = id;
        this.ratings = ratings;
        this.name = name;
        this.description = description;
    }

    public Places() {
        this.id = 0;
        this.ratings = 0;
        this.name = "";
        this.description = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
