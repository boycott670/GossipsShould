package com.nespresso.recruitment.gossip.parsers;

import java.util.Collection;

import com.nespresso.recruitment.gossip.gossips.Gossip;

public interface GossipsParser
{
  void setGossips(final String... gossips);
  
  Collection<Gossip> parseGossips();
}
