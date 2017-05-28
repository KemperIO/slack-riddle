package io.kemper.api;

import java.util.List;

public class MessageActionRequest {
    private List<Action> actions;

    private String callbackId;

    private Team team;
    private Channel channel;
    private User user;

    public MessageActionRequest(){}

    public MessageActionRequest(List<Action> actions, String callbackId, Team team, Channel channel, User user) {
        this.actions = actions;
        this.callbackId = callbackId;
        this.team = team;
        this.channel = channel;
        this.user = user;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public String getCallbackId() {
        return callbackId;
    }

    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageActionRequest that = (MessageActionRequest) o;

        if (actions != null ? !actions.equals(that.actions) : that.actions != null) return false;
        if (callbackId != null ? !callbackId.equals(that.callbackId) : that.callbackId != null) return false;
        if (team != null ? !team.equals(that.team) : that.team != null) return false;
        if (channel != null ? !channel.equals(that.channel) : that.channel != null) return false;
        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        int result = actions != null ? actions.hashCode() : 0;
        result = 31 * result + (callbackId != null ? callbackId.hashCode() : 0);
        result = 31 * result + (team != null ? team.hashCode() : 0);
        result = 31 * result + (channel != null ? channel.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MessageActionRequest{" +
                "actions=" + actions +
                ", callbackId='" + callbackId + '\'' +
                ", team=" + team +
                ", channel=" + channel +
                ", user=" + user +
                '}';
    }
}
