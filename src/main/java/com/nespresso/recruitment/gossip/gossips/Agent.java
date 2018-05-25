package com.nespresso.recruitment.gossip.gossips;

public final class Agent extends Doctor
{

  public Agent(String name)
  {
    super(name);
  }

  @Override
  boolean hasMessage()
  {
    return super.hasMessage();
  }

  @Override
  boolean alwaysListening()
  {
    return true;
  }

  @Override
  void prespread()
  {
    super.prespread();
    reset();
  }

}
