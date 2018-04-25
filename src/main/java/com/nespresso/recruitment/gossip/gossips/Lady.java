package com.nespresso.recruitment.gossip.gossips;

import java.util.Optional;

public final class Lady extends Gossip
{
  private String message;

  public Lady(String name)
  {
    super(name);
  }

  @Override
  Gossip recipient()
  {
    return backGossip instanceof Doctor ? forthGossip : null;
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
