package de.htwberlin.webtech.healthBlog.web.api;


import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class BlogEntryManipulationRequest {

    @PastOrPresent(message = "Bitte ein gültiges Datum erfassen!")
    private LocalDate date;
    @Positive(message = "Bitte Schritte erfassen!")
    private int steps;
    @Positive(message = "Bitte Kalorien erfassen!")
    private int calories;

    private int emojis;
    @NotBlank(message = "Bitte einen Eintrag erfassen!")
    private String diaryEntry;


    public BlogEntryManipulationRequest(LocalDate date, int steps, int calories, int emojis, String diaryEntry) {
        this.date = date;
        this.steps = steps;
        this.calories = calories;
        this.emojis = emojis;
        this.diaryEntry = diaryEntry;
    }

    public BlogEntryManipulationRequest() {    }

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
