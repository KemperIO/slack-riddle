package io.kemper.domain;

public class Riddle {

    private Integer id;
    private String question;
    private String answer;

    public Riddle(){}

    public Riddle(String question) {
        this.question = question;
    }

    public Riddle(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Riddle(Integer id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Riddle riddle = (Riddle) o;

        if (id != null ? !id.equals(riddle.id) : riddle.id != null) return false;
        if (question != null ? !question.equals(riddle.question) : riddle.question != null) return false;
        return answer != null ? answer.equals(riddle.answer) : riddle.answer == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Riddle{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
