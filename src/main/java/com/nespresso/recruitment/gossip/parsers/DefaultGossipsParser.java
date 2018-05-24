package com.nespresso.recruitment.gossip.parsers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.nespresso.recruitment.gossip.gossips.Doctor;
import com.nespresso.recruitment.gossip.gossips.Gossip;
import com.nespresso.recruitment.gossip.gossips.Mister;

public final class DefaultGossipsParser implements GossipsParser
{
  
  private static final Map<String, Supplier<? extends Gossip>> GOSSIP_CODE_TO_GOSSIP = new HashMap<String, Supplier<? extends Gossip>>()
  {
    private static final long serialVersionUID = -8999329223598955674L;

    {
      put("Mr", Mister::new);
      put("Dr", Doctor::new);
    }
  };
  
  private String[] gossips;

  @Override
  public void setGossips(String... gossips)
  {
    this.gossips = gossips;
  }

  @Override
  public Map<String, Gossip> parseGossips()
  {
    return Arrays.stream(gossips)
        .map(gossip -> gossip.split(" "))
        .collect(Collectors.toMap(tokens -> tokens[1], tokens -> GOSSIP_CODE_TO_GOSSIP.get(tokens[0])
            .get()));
  }

}
