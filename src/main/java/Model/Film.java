package Model;

public class Film {

    private int film_id;

    private String name;

    private int year;

    private int duration;

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Film(int film_id, String name, int year, int duration) {
        this.film_id = film_id;
        this.name = name;
        this.year = year;
        this.duration = duration;
    }
}
