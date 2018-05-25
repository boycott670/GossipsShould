package com.nespresso.recruitment.gossip.gossips;

import java.util.Optional;

public final class Mister extends Gossip
{
  
  private String message;

  public Mister(String name)
  {
    super(name);
  }

  @Override
  boolean hasMessage()
  {
    return message != null;
  }

  @Override
  String message()
  {
    final String message = this.message;
    
    this.message = null;
    
    return message;
  }

  @Override
  public void say(String message)
  {
    this.message = message;
  }

  @Override
  public String ask()
  {
    return Optional.ofNullable(message).orElse("");
  }
  
}
