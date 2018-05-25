package com.nespresso.recruitment.gossip.gossips;

public abstract class Gossip
{
  private final String name;
  
  Gossip forthGossip;
  
  Gossip backGossip;
  
  Gossip(String name)
  {
    this.name = name;
  }

  public final String getName()
  {
    return name;
  }

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
  
  String transformMessage(final String message)
  {
    return message;
  }
  
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
  
  abstract void reset();
  
  void prespread()
  {
    
  }
  
  public abstract void say(final String message);
  
  public abstract String ask();
  
  public boolean isTargetAlwaysListening()
  {
    return targetGossip().alwaysListening();
  }
  
  public final boolean spread()
  {
    prespread();
    
    if (hasMessage())
    {
      targetGossip().say(transformMessage(message()));
      
      return !targetGossip().continueSpreading();
    }
    
    return false;
  }

  @Override
  public final boolean equals(Object obj)
  {
    return super.equals(obj);
  }

  @Override
  public final int hashCode()
  {
    return super.hashCode();
  }
}
