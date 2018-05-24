package com.nespresso.recruitment.gossip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.nespresso.recruitment.gossip.gossips.Gossip;
import com.nespresso.recruitment.gossip.parsers.DefaultGossipsParser;
import com.nespresso.recruitment.gossip.parsers.GossipsParser;

public final class Gossips
{
  private static enum ACTION
  {
    FROM,
    SAY;
  }
  
  private ACTION lastAction;
  private Gossip lastBackGossip;
  private String lastMessageToSay;
  
  private final GossipsParser parser;
  
  private final Map<String, Gossip> gossips;
  
  private final Collection<Gossip> sequenceOfGossips;
  
  public Gossips(final String... gossips)
  {
    parser = new DefaultGossipsParser();
    
    parser.setGossips(gossips);
    
    this.gossips = parser.parseGossips();
    
    sequenceOfGossips = new ArrayList<>();
  }
  
  public Gossips from(final String backGossip)
  {
    lastAction = ACTION.FROM;
    lastBackGossip = gossips.get(backGossip);
    
    sequenceOfGossips.add(lastBackGossip);
    
    return this;
  }
  
  public Gossips say(final String message)
  {
    lastAction = ACTION.SAY;
    lastMessageToSay = message;
    return this;
  }
  
  public Gossips to(final String forthGossip)
  {
    if (lastAction == ACTION.FROM)
    {
      lastBackGossip.setForthGossip(gossips.get(forthGossip));
      gossips.get(forthGossip).setBackGossip(lastBackGossip);
    }
    else
    {
      gossips.get(forthGossip).say(lastMessageToSay);
    }
    
    return this;
  }
  
  public String ask(final String gossip)
  {
    return gossips.get(gossip).ask();
  }
  
  public void spread()
  {
    boolean spreadBefore = false;
    
    for (final Gossip gossip : sequenceOfGossips)
    {
      if (!spreadBefore)
      {
        if (gossip.spread())
        {
          spreadBefore = true;
        }
      }
      else
      {
        if (gossip.isTargetAlwaysListening())
        {
          gossip.spread();
        }
      }
    }
  }
}
