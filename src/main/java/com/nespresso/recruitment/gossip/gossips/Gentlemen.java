package com.nespresso.recruitment.gossip.gossips;

public final class Gentlemen extends Mister
{

  public Gentlemen(String name)
  {
    super(name);
  }

  @Override
  Gossip targetGossip()
  {
    return backGossip;
  }

  @Override
  String transformMessage(String message)
  {
    return new StringBuffer(message).reverse().toString();
  }

}
