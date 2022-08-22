package com.example.GoGOQr.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "rewards")
public class Rewards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
     private Long id;
     int StationId;
     int Points;
    @ManyToOne
    @JoinColumn(name = "userrewards_id")
    User Userrewards;

    public Rewards() {
    }

    public Rewards(long id, @NotBlank int stationId, int points, User userrewards) {
        StationId = stationId;
        Points = points;
        Userrewards = userrewards;
        id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStationId() {
        return StationId;
    }

    public void setStationId(int stationId) {
        StationId = stationId;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }

    public User getUserrewards() {
        return Userrewards;
    }

    public void setUserrewards(User userrewards) {
        Userrewards = userrewards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rewards)) return false;
        Rewards rewards = (Rewards) o;
        return getStationId() == rewards.getStationId() && getPoints() == rewards.getPoints() && Objects.equals(getId(), rewards.getId()) && Objects.equals(getUserrewards(), rewards.getUserrewards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStationId(), getPoints(), getUserrewards());
    }

    @Override
    public String toString() {
        return "Rewards{" +
                "id=" + id +
                ", StationId=" + StationId +
                ", Points=" + Points +
                ", Userrewards=" + Userrewards +
                '}';
    }


}
