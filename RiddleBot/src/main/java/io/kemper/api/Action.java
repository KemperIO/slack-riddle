package io.kemper.api;

public class Action {
    private String name;
    private String text;
    private String type;
    private String value;

    public Action() {}

    public Action(String name, String text, String type, String value) {
        this.name = name;
        this.text = text;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        if (name != null ? !name.equals(action.name) : action.name != null) return false;
        if (text != null ? !text.equals(action.text) : action.text != null) return false;
        if (type != null ? !type.equals(action.type) : action.type != null) return false;
        return value != null ? value.equals(action.value) : action.value == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Action{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
