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
  Gossip recipient()
  {
    return forthGossip;
  }

  @Override
  String gossip()
  {
    final String gossip = message;

    message = null;

    return gossip;
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
