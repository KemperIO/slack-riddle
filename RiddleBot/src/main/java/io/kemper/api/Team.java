package io.kemper.api;

public class Team {
    private String id;
    private String domain;

    public Team(){}

    public Team(String id, String domain) {
        this.id = id;
        this.domain = domain;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (id != null ? !id.equals(team.id) : team.id != null) return false;
        return domain != null ? domain.equals(team.domain) : team.domain == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (domain != null ? domain.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
