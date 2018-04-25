package com.nespresso.recruitment.gossip.gossips;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public final class Agent extends Gossip
{
  private final Collection<String> message = new ArrayList<>();
  private boolean gossiped = false;

  public Agent(String name)
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
      message.clear();
    }

    gossiped = true;

    return null;
  }

  @Override
  public boolean say(String message)
  {
    this.message.add(message);
    return true;
  }

  @Override
  public Optional<String> ask()
  {
    return Optional.of(message)
        .filter(message -> !message.isEmpty())
        .map(Collection::stream)
        .map(message -> message.collect(Collectors.joining(", ")));
  }

}
