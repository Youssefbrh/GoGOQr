package com.example.GoGOQr.Service;

import com.example.GoGOQr.Model.Rewards;

import java.util.List;

public interface RewardsService {
    void AddReward(Rewards r);
    List<Rewards> getallrewards();
}
