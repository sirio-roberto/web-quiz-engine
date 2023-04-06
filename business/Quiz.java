package engine.business;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;

public class Quiz {
    private Integer id;

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String text;

    @NotNull
    @Size(min = 2)
    private List<String> options;

    private HashSet<Integer> answer = new HashSet<>();

    private static int idCounter = 0;

    public Quiz() {
        this.id = idCounter++;
    }

    public Quiz(String title, String text, List<String> options, HashSet<Integer> answer) {
        this.id = idCounter++;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
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

    public HashSet<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(HashSet<Integer> answer) {
        this.answer = answer;
    }
}
