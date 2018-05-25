package com.nespresso.recruitment.gossip.gossips;

import java.util.Optional;

public class Mister extends Gossip
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
  final String message()
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
  public final String ask()
  {
    return Optional.ofNullable(message).orElse("");
  }

  @Override
  final void reset()
  {
    message = null;
  }

  @Override
  final Gossip targetGossip()
  {
    return super.targetGossip();
  }

  @Override
  final boolean alwaysListening()
  {
    return super.alwaysListening();
  }

  @Override
  final boolean continueSpreading()
  {
    return super.continueSpreading();
  }
  
}
