package engine.business;

import java.util.List;

public class QuizDTO {
    private Long id;
    private String title;
    private String text;
    private List<String> options;

    public QuizDTO(Long id, String title, String text, List<String> options) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
    }

    public QuizDTO(Quiz quiz) {
        this.id = quiz.getId();
        this.title = quiz.getTitle();
        this.text = quiz.getText();
        this.options = quiz.getOptions();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
