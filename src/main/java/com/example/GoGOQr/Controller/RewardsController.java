package com.example.GoGOQr.Controller;

import com.example.GoGOQr.Model.Rewards;
import com.example.GoGOQr.Model.Status;
import com.example.GoGOQr.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RewardsController {
    @Autowired
    RewardsRep rewardsRep;
    @Autowired
    UserRep userRep;
  @PostMapping("rewards/add")
  public Status  addreward(@Valid @RequestBody  Rewards newRewards){
      List<User> users = (List<User> ) userRep.findAll();
      for (User other : users) {
          if (newRewards.getUserrewards().equals(other)) {
              rewardsRep.save(newRewards);
              return Status.SUCCESS;
          }
      }
return Status.FAILURE;
  }

  @RequestMapping(value = "/rewards/all",method = RequestMethod.GET)
    public List<Rewards> Getrewards(Rewards rewards){

      List<Rewards> allrewards = (List<Rewards>) rewardsRep.findAll();
      return  allrewards;
  }

}
