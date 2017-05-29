package io.kemper.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageActionRequest {
    private List<Action> actions;

    public MessageActionRequest(){}

    public MessageActionRequest(List<Action> actions) {
        this.actions = actions;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageActionRequest that = (MessageActionRequest) o;

        return actions != null ? actions.equals(that.actions) : that.actions == null;
    }

    @Override
    public int hashCode() {
        return actions != null ? actions.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MessageActionRequest{" +
                "actions=" + actions +
                '}';
    }
}
