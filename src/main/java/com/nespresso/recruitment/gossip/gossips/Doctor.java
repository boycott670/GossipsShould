package com.nespresso.recruitment.gossip.gossips;

import java.util.ArrayList;
import java.util.List;

public final class Doctor extends Gossip
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
  String message()
  {
    return messages.get(currentMesesageToSayIndex++);
  }

  @Override
  public void say(String message)
  {
    messages.add(message);
  }

  @Override
  public String ask()
  {
    return String.join(", ", messages);
  }

  @Override
  boolean continueSpreading()
  {
    return currentMesesageToSayIndex < messages.size() - 1;
  }

}
