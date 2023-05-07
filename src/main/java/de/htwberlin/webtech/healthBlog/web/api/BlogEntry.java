package de.htwberlin.webtech.healthBlog.web.api;

import java.time.LocalDate;


/**
 * Repräsentiert einen Eintrag im Health Blog.
 */
public class BlogEntry {

    private long id;
    private LocalDate date;
    private int steps;
    private int calories;
    private String[] emojis = {"😔", "😐", "😄"};
    private int emojiIndex;
    private String diaryEntry;

    /**
     * Erstellt einen neuen BlogEntry.
     *
     * @param date        das Datum des Eintrags
     * @param steps       die Anzahl der Schritte an diesem Tag
     * @param calories    die aufgenommenen Kalorien an diesem Tag
     * @param emojiIndex  das Emoji, das den Gemütszustand des Benutzers darstellt
     * @param diaryEntry  der Tagebucheintrag des Benutzers
     */
    public BlogEntry(long id, LocalDate date, int steps, int calories, int emojiIndex, String diaryEntry) {
        this.id = id;
        this.date = date;
        this.steps = steps;
        this.calories = calories;
        this.emojiIndex = emojiIndex;
        this.diaryEntry = diaryEntry;
    }

    /**
     * Gibt die Id des Eintrags zurück
     *
     * @return die Id des Eintrags
     * */
    public long getId() {
        return id;
    }

    /**
     * Setzt die Id des Eintrags.
     *
     * @param id die neue Id des Eintrags
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gibt das Datum des Eintrags zurück.
     *
     * @return das Datum des Eintrags
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Setzt das Datum des Eintrags.
     *
     * @param date das neue Datum des Eintrags
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gibt die Anzahl der Schritte an diesem Tag zurück.
     *
     * @return die Anzahl der Schritte
     */
    public int getSteps() {
        return steps;
    }

    /**
     * Setzt die Anzahl der Schritte an diesem Tag.
     *
     * @param steps die neue Anzahl der Schritte
     */
    public void setSteps(int steps) {
        this.steps = steps;
    }

    /**
     * Gibt die aufgenommenen Kalorien an diesem Tag zurück.
     *
     * @return die aufgenommenen Kalorien
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Setzt die aufgenommenen Kalorien an diesem Tag.
     *
     * @param calories die neuen aufgenommenen Kalorien
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * Gibt den Index des gewählten Emojis im Emojis-Array zurück.
     *
     * @return der Index des gewählten Emojis
     */
    public int getEmojiIndex() {
        return emojiIndex;
    }

    /**
     * Setzt den Index des gewählten Emojis im Emojis-Array.
     *
     * @param emojiIndex der neue Index des gewählten Emojis
     */
    public void setEmojiIndex(int emojiIndex) {
        this.emojiIndex = emojiIndex;
    }

    /**
     * Gibt das gewählte Emoji zurück.
     *
     * @return das gewählte Emoji
     */
    public String getSelectedEmoji() {
        return emojis[emojiIndex];
    }

    /**
     * Gibt den Tagebucheintrag des Benutzers zurück.
     *
     * @return der Tagebucheintrag
     */
    public String getDiaryEntry() {
        return diaryEntry;
    }

    /**
     * Setzt den Tagebucheintrag des Benutzers.
     *
     * @param diaryEntry der neue Tagebucheintrag
     */
    public void setDiaryEntry(String diaryEntry) {
        this.diaryEntry = diaryEntry;
    }
}

