package engine.business;

import java.util.List;

public class Quiz {
    private Integer id;
    private String title;
    private String text;
    private List<String> options;

    private Integer answer;

    private static int idCounter = 0;

    public Quiz() {
    }

    public Quiz(String title, String text, List<String> options, Integer answer) {
        this.id = idCounter;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
        idCounter++;
    }

    public Integer getId() {
        if (id == null) {
            id = idCounter++;
        }
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }
}
