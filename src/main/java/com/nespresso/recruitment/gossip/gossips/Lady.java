package com.nespresso.recruitment.gossip.gossips;

public final class Lady extends Mister
{

  public Lady(String name)
  {
    super(name);
  }

  @Override
  boolean hasMessage()
  {
    return super.hasMessage() && backGossip instanceof Doctor;
  }

  @Override
  public boolean isTargetAlwaysListening()
  {
    return false;
  }

}
