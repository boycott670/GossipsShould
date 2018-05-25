package com.nespresso.recruitment.gossip.gossips;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Gossip
{

  private final List<String> messages = new ArrayList<>();
  private int currentMesesageToSayIndex = 0;
  
  public Doctor(String name)
  {
    super(name);
  }

  @Override
  boolean hasMessage()
  {
    return currentMesesageToSayIndex < messages.size();
  }

  @Override
  final String message()
  {
    return messages.get(currentMesesageToSayIndex++);
  }

  @Override
  public final void say(String message)
  {
    messages.add(message);
  }

  @Override
  public final String ask()
  {
    return String.join(", ", messages);
  }

  @Override
  final boolean continueSpreading()
  {
    return currentMesesageToSayIndex < messages.size() - 1;
  }

  @Override
  final Gossip targetGossip()
  {
    return super.targetGossip();
  }

  @Override
  final void reset()
  {
    messages.clear();
    currentMesesageToSayIndex = 0;
  }

}
