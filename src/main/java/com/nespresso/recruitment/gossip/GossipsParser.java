package com.nespresso.recruitment.gossip;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.nespresso.recruitment.gossip.gossips.Agent;
import com.nespresso.recruitment.gossip.gossips.Doctor;
import com.nespresso.recruitment.gossip.gossips.Gentlemen;
import com.nespresso.recruitment.gossip.gossips.Gossip;
import com.nespresso.recruitment.gossip.gossips.Lady;
import com.nespresso.recruitment.gossip.gossips.Mister;
import com.nespresso.recruitment.gossip.gossips.Professor;

final class GossipsParser
{
  static Gossip[] parseGossips(final String[] gossips)
  {
    final Map<String, Function<String, ? extends Gossip>> gossipsSupplier = new HashMap<>();

    gossipsSupplier.put("Mr", Mister::new);
    gossipsSupplier.put("Dr", Doctor::new);
    gossipsSupplier.put("Agent", Agent::new);
    gossipsSupplier.put("Pr", Professor::new);
    gossipsSupplier.put("Lady", Lady::new);
    gossipsSupplier.put("Sir", Gentlemen::new);

    return Arrays.stream(gossips)
        .map(gossip ->
        {
          final String[] tokens = gossip.split("\\s+");

          return gossipsSupplier.get(tokens[0])
              .apply(tokens[1]);
        })
        .toArray(Gossip[]::new);
  }

  private GossipsParser()
  {

  }
}
