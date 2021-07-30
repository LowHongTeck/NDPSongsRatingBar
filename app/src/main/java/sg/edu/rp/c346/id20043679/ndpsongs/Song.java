package sg.edu.rp.c346.id20043679.ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {

    private int id;
    private String title;
    private String singers;
    private int year;
    private float stars;

    public Song(int id, String title, String singers, int year, float stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getSingers() { return singers; }
    public int getYear() { return year; }
    public float getStars() { return stars; }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }


//    public String toString() {
//
//        String showStar = "";
//
//        for (int i = 0; i < stars; i++) {
//            showStar += "*";
//        }
//
//        return year + "\n" + title + "\n" + singers
//            + " - " + year  + "\n" + showStar;
//    }

//    public String showStar() {
//
//        String showStar = "";
//
//        for (int i = 0; i < stars; i++) {
//            showStar += " * ";
//        }
//
//
//
//        return showStar;
//
//    }
}
