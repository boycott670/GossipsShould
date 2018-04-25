package com.nespresso.recruitment.gossip.gossips;

import java.util.Optional;

public abstract class Gossip
{
  private final String name;

  Gossip forthGossip;
  Gossip backGossip;

  Gossip(String name)
  {
    this.name = name;
  }

  abstract Gossip recipient();

  abstract String gossip();

  public abstract boolean say(final String message);

  public abstract Optional<String> ask();

  public final String getName()
  {
    return name;
  }

  public final void setForthGossip(Gossip forthGossip)
  {
    this.forthGossip = forthGossip;
  }

  public final void setBackGossip(Gossip backGossip)
  {
    this.backGossip = backGossip;
  }

  public final boolean spread()
  {
    if (recipient() != null)
    {
      final String gossip = gossip();

      if (gossip != null)
      {
        return recipient().say(gossip);
      }
    }

    return true;
  }
}
