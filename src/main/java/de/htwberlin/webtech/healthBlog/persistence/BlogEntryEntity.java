package de.htwberlin.webtech.healthBlog.persistence;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "blog_entries") // "blog_entries" is the name of the table in the database
public class BlogEntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // "id" is the name of the column in the database
    private long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "steps", nullable = false)
    private int steps;

    @Column(name = "calories", nullable = false)
    private int calories;

    @Column(name = "emojis", nullable = false)
    private int emojis;

    @Column(name = "diary_entry")
    private String diaryEntry;

    public BlogEntryEntity(long id, LocalDate date, int steps, int calories, int emojis, String diaryEntry) {
        //this.id = id; überflüssig, da von der DB generiert
        this.date = date;
        this.steps = steps;
        this.calories = calories;
        this.emojis = emojis;
        this.diaryEntry = diaryEntry;
    }

    protected BlogEntryEntity() {}

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getEmojis() {
        return emojis;
    }

    public void setEmojis(int emojis) {
        this.emojis = emojis;
    }

    public String getDiaryEntry() {
        return diaryEntry;
    }

    public void setDiaryEntry(String diaryEntry) {
        this.diaryEntry = diaryEntry;
    }
}
