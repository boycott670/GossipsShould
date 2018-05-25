package com.nespresso.recruitment.gossip.gossips;

public final class Professor extends Mister
{
  
  private int delay = 0;

  public Professor(String name)
  {
    super(name);
  }

  @Override
  boolean hasMessage()
  {
    return super.hasMessage() && delay > 1;
  }

  @Override
  void prespread()
  {
    super.prespread();
    delay++;
  }

  @Override
  public void say(String message)
  {
    super.say(message);
    delay = 0;
  }

}
