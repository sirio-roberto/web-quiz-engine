package engine.business;

import java.util.List;

public class QuizDTO {
    private Integer id;
    private String title;
    private String text;
    private List<String> options;

    private static int idCounter = 0;

    public QuizDTO(String title, String text, List<String> options) {
        this.id = idCounter;
        this.title = title;
        this.text = text;
        this.options = options;
        idCounter++;
    }

    public Integer getId() {
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
}
