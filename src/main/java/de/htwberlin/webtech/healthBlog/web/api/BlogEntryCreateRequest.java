package de.htwberlin.webtech.healthBlog.web.api;

import java.time.LocalDate;

public class BlogEntryCreateRequest {
    private LocalDate date;
    private int steps;
    private int calories;
    private int emojis;
    private String diaryEntry;


    public BlogEntryCreateRequest(LocalDate date, int steps, int calories, int emojis, String diaryEntry) {
        this.date = date;
        this.steps = steps;
        this.calories = calories;
        this.emojis = emojis;
        this.diaryEntry = diaryEntry;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getSteps() {
        return steps;
    }

    public int getCalories() {
        return calories;
    }

    public int getEmojis() {
        return emojis;
    }

    public String getDiaryEntry() {
        return diaryEntry;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setEmojis(int emojis) {
        this.emojis = emojis;
    }

    public void setDiaryEntry(String diaryEntry) {
        this.diaryEntry = diaryEntry;
    }
}
