package com.nespresso.recruitment.gossip;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.nespresso.recruitment.gossip.gossips.Gossip;

final class Gossips
{
  private static enum ACTION
  {
    FROM, SAY;
  }

  private final Map<String, Gossip> gossips;

  private ACTION lastAction;
  private String lastMessage;
  private String lastGossip;

  Gossips(final String... gossips)
  {
    this.gossips = Collections.unmodifiableMap(Arrays.stream(GossipsParser.parseGossips(gossips))
        .collect(Collectors.toMap(Gossip::getName, Function.identity(), (gossip1, gossip2) ->
        {
          throw new IllegalArgumentException("Duplicate gossip name");
        }, LinkedHashMap::new)));
  }

  Gossips from(final String gossip)
  {
    lastAction = ACTION.FROM;
    lastGossip = gossip;
    return this;
  }

  Gossips say(final String message)
  {
    lastAction = ACTION.SAY;
    lastMessage = message;
    return this;
  }

  Gossips to(final String gossip)
  {
    if (lastAction == ACTION.FROM)
    {
      gossips.get(lastGossip)
          .setForthGossip(gossips.get(gossip));
      gossips.get(gossip)
          .setBackGossip(gossips.get(lastGossip));
    }
    else
    {
      gossips.get(gossip)
          .say(lastMessage);
    }

    return this;
  }
  
  String ask(final String gossip)
  {
    return gossips.get(gossip)
        .ask()
        .orElse("");
  }
  
  void spread()
  {
    for (final Gossip gossip : gossips.values())
    {
      if (!gossip.spread())
      {
        break;
      }
    }
  }
}
