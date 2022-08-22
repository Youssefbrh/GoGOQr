package com.example.GoGOQr.Controller;

import com.example.GoGOQr.Model.Rewards;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RewardsRep extends CrudRepository<Rewards, Long>, JpaSpecificationExecutor<Rewards> {

}
