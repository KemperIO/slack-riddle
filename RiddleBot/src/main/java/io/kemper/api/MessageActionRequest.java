package io.kemper.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageActionRequest {
    private List<Action> actions;

    @JsonProperty("response_url")
    private String responseUrl;

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

    public String getResponseUrl() {
        return responseUrl;
    }

    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageActionRequest that = (MessageActionRequest) o;

        if (actions != null ? !actions.equals(that.actions) : that.actions != null) return false;
        return responseUrl != null ? responseUrl.equals(that.responseUrl) : that.responseUrl == null;
    }

    @Override
    public int hashCode() {
        int result = actions != null ? actions.hashCode() : 0;
        result = 31 * result + (responseUrl != null ? responseUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MessageActionRequest{" +
                "actions=" + actions +
                ", responseUrl='" + responseUrl + '\'' +
                '}';
    }
}
