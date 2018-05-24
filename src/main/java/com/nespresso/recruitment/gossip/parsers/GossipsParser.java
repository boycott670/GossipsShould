package com.nespresso.recruitment.gossip.parsers;

import java.util.Map;

import com.nespresso.recruitment.gossip.gossips.Gossip;

public interface GossipsParser
{
  void setGossips(final String... gossips);
  
  Map<String, Gossip> parseGossips();
}
