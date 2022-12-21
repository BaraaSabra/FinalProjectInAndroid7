package com.example.finalprojectinandroid.RoomDataBase;

import androidx.room.Entity;

@Entity
public class PuzzleData {
    int puzzle_number;
    String puzzle_text;
    String answer_1;
    String answer_2;
    String answer_3;
    String answer_4;
    String true_answer;
    int points;
    int duration;

    public int getPuzzle_number() {
        return puzzle_number;
    }

    public void setPuzzle_number(int puzzle_number) {
        this.puzzle_number = puzzle_number;
    }

    public String getPuzzle_text() {
        return puzzle_text;
    }

    public void setPuzzle_text(String puzzle_text) {
        this.puzzle_text = puzzle_text;
    }

    public String getAnswer_1() {
        return answer_1;
    }

    public void setAnswer_1(String answer_1) {
        this.answer_1 = answer_1;
    }

    public String getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(String answer_2) {
        this.answer_2 = answer_2;
    }

    public String getAnswer_3() {
        return answer_3;
    }

    public void setAnswer_3(String answer_3) {
        this.answer_3 = answer_3;
    }

    public String getAnswer_4() {
        return answer_4;
    }

    public void setAnswer_4(String answer_4) {
        this.answer_4 = answer_4;
    }

    public String getTrue_answer() {
        return true_answer;
    }

    public void setTrue_answer(String true_answer) {
        this.true_answer = true_answer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public PuzzleData(int puzzle_number, String puzzle_text, String answer_1, String answer_2, String answer_3, String answer_4, String true_answer, int points, int duration) {
        this.puzzle_number = puzzle_number;
        this.puzzle_text = puzzle_text;
        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
        this.answer_3 = answer_3;
        this.answer_4 = answer_4;
        this.true_answer = true_answer;
        this.points = points;
        this.duration = duration;
    }
}
