package com.nespresso.recruitment.gossip.gossips;

import java.util.Optional;

public final class Professor extends Gossip
{
  private String message;
  private boolean gossiped = false;

  public Professor(String name)
  {
    super(name);
  }

  @Override
  Gossip recipient()
  {
    return forthGossip;
  }

  @Override
  String gossip()
  {
    if (gossiped)
    {
      final String gossip = message;

      message = null;

      return gossip;
    }

    gossiped = true;

    return null;
  }

  @Override
  public boolean say(String message)
  {
    this.message = message;
    return false;
  }

  @Override
  public Optional<String> ask()
  {
    return Optional.ofNullable(message);
  }

}
