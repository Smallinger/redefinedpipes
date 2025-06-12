package com.github.smallinger.redefinedpipes.network.graph;

import com.github.smallinger.redefinedpipes.network.Network;
import com.github.smallinger.redefinedpipes.network.pipe.Destination;
import com.github.smallinger.redefinedpipes.network.pipe.DestinationType;
import com.github.smallinger.redefinedpipes.network.pipe.Pipe;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.util.*;

public class NetworkGraph {
    private final Network network;

    private Set<Pipe> pipes = new HashSet<>();
    private Map<DestinationType, List<Destination>> destinations = new HashMap<>();

    public NetworkGraph(Network network) {
        this.network = network;
    }

    public NetworkGraphScannerResult scan(Level originLevel, BlockPos originPos) {
        NetworkGraphScanner scanner = new NetworkGraphScanner(pipes, network.getType());

        NetworkGraphScannerResult result = scanner.scanAt(originLevel, originPos);

        this.pipes = result.getFoundPipes();

        result.getNewPipes().forEach(p -> p.joinNetwork(network));
        result.getRemovedPipes().forEach(Pipe::leaveNetwork);

        destinations.clear();

        for (Destination destination : result.getDestinations()) {
            destinations.computeIfAbsent(destination.getType(), type -> new ArrayList<>()).add(destination);
        }

        return result;
    }

    public Set<Pipe> getPipes() {
        return pipes;
    }

    public List<Destination> getDestinations(DestinationType type) {
        return destinations.getOrDefault(type, Collections.emptyList());
    }
} 