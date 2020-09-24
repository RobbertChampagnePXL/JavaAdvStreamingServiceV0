package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

import static java.lang.Math.abs;

public class Movie extends Content implements Playable {
    public static final int LONG_PLAYING_TIME = 2 * 60 + 15;
    private String director;
    private LocalDate releaseDate;
    private int duration;
    private Genre genre;

    public Movie(String title, Rating maturityRating) {
        super(title, maturityRating);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void play() {
        System.out.println("Playing " + this);
    }

    @Override
    public void pause() {
        System.out.println("Pausing " + this);
    }

    public void setDuration(int duration) {
        this.duration = abs(duration);
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isLongPlayingTime() {
        return duration >= LONG_PLAYING_TIME;
    }

    public String getPlayingTime () {
        String time = "?";

        if (duration > 0 && duration < 60){
            time = duration + " min";
        }else if(duration >= 60 && duration % 60 == 0){
            time = duration / 60 + " h";
        }else if(duration >= 60 && duration % 60 != 0){
            time = (int)(duration / 60) + " h " + duration % 60 + " min" ;
        }

        return time;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        if (releaseDate != null) {
            builder.append(" (").append(releaseDate.getYear()).append(")"); //Titanic (1997)
        }
        return builder.toString();
    }
}
