package com.nespresso.recruitment.gossip.gossips;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class Doctor extends Gossip
{
  private final List<String> message = new ArrayList<>();
  private int messageIndex = 0;

  public Doctor(String name)
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
    return messageIndex < message.size() ? message.get(messageIndex++) : null;
  }

  @Override
  public boolean say(String message)
  {
    this.message.add(message);
    return messageIndex < this.message.size() - 1;
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
