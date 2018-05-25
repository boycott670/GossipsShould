package com.nespresso.recruitment.gossip.parsers;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.nespresso.recruitment.gossip.gossips.Agent;
import com.nespresso.recruitment.gossip.gossips.Doctor;
import com.nespresso.recruitment.gossip.gossips.Gossip;
import com.nespresso.recruitment.gossip.gossips.Mister;
import com.nespresso.recruitment.gossip.gossips.Professor;

public final class DefaultGossipsParser implements GossipsParser
{
  
  private static final Map<String, Function<String, ? extends Gossip>> GOSSIP_CODE_TO_GOSSIP = new HashMap<String, Function<String, ? extends Gossip>>()
  {
    private static final long serialVersionUID = -8999329223598955674L;

    {
      put("Mr", Mister::new);
      put("Dr", Doctor::new);
      put("Agent", Agent::new);
      put("Pr", Professor::new);
    }
  };
  
  private String[] gossips;

  @Override
  public void setGossips(String... gossips)
  {
    this.gossips = gossips;
  }

  @Override
  public Collection<Gossip> parseGossips()
  {
    return Arrays.stream(gossips)
        .map(gossip -> gossip.split(" "))
        .map(tokens -> GOSSIP_CODE_TO_GOSSIP.get(tokens[0]).apply(tokens[1]))
        .collect(Collectors.toSet());
  }

}
