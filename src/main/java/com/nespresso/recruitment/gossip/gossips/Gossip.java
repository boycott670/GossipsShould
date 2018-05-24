package com.nespresso.recruitment.gossip.gossips;

public abstract class Gossip
{
  Gossip forthGossip;
  
  Gossip backGossip;
  
  public final void setForthGossip(final Gossip gossip)
  {
    forthGossip = gossip;
  }
  
  public final void setBackGossip(final Gossip gossip)
  {
    backGossip = gossip;
  }
  
  abstract boolean hasMessage();
  
  abstract String message();
  
  Gossip targetGossip()
  {
    return forthGossip;
  }
  
  boolean alwaysListening()
  {
    return false;
  }
  
  boolean continueSpreading()
  {
    return false;
  }
  
  public abstract void say(final String message);
  
  public abstract String ask();
  
  public final boolean isTargetAlwaysListening()
  {
    return targetGossip().alwaysListening();
  }
  
  public final boolean spread()
  {
    if (hasMessage())
    {
      targetGossip().say(message());
      
      return !targetGossip().continueSpreading();
    }
    
    return false;
  }
}
