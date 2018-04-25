package com.nespresso.recruitment.gossip.gossips;

import java.util.Optional;

public final class Gentlemen extends Gossip
{
  private String message;

  public Gentlemen(String name)
  {
    super(name);
  }

  @Override
  Gossip recipient()
  {
    return backGossip;
  }

  @Override
  String gossip()
  {
    final String gossip = message;

    message = null;

    return new StringBuffer(gossip).reverse()
        .toString();
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
