package com.github.smallinger.redefinedpipes.network.item;

import com.github.smallinger.redefinedpipes.RedefinedPipes;
import com.github.smallinger.redefinedpipes.network.Network;
import com.github.smallinger.redefinedpipes.network.graph.NetworkGraphScannerResult;
import com.github.smallinger.redefinedpipes.network.item.routing.DestinationPathCache;
import com.github.smallinger.redefinedpipes.network.item.routing.DestinationPathCacheFactory;
import com.github.smallinger.redefinedpipes.network.item.routing.EdgeFactory;
import com.github.smallinger.redefinedpipes.network.pipe.Destination;
import com.github.smallinger.redefinedpipes.network.pipe.DestinationType;
import com.github.smallinger.redefinedpipes.network.pipe.Pipe;
import com.github.smallinger.redefinedpipes.routing.Edge;
import com.github.smallinger.redefinedpipes.routing.Graph;
import com.github.smallinger.redefinedpipes.routing.Node;
import com.github.smallinger.redefinedpipes.routing.NodeIndex;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemNetwork extends Network {
    public static final ResourceLocation TYPE = ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "item");

    private DestinationPathCache destinationPathCache;

    public ItemNetwork(BlockPos originPos, String id) {
        super(originPos, id);
    }

    @Override
    public NetworkGraphScannerResult scanGraph(Level level, BlockPos pos) {
        NetworkGraphScannerResult result = super.scanGraph(level, pos);

        updateRouting(result, graph.getDestinations(DestinationType.ITEM_HANDLER));

        return result;
    }

    @Override
    public void onMergedWith(Network mainNetwork) {

    }

    @Override
    public ResourceLocation getType() {
        return TYPE;
    }

    private void updateRouting(NetworkGraphScannerResult result, List<Destination> destinations) {
        List<Node<BlockPos>> nodes = buildNodes(result.getFoundPipes());

        NodeIndex<BlockPos> nodeIndex = NodeIndex.of(nodes);

        EdgeFactory edgeFactory = new EdgeFactory(nodeIndex, result.getRequests());
        List<Edge<BlockPos>> edges = edgeFactory.create();

        Graph<BlockPos> graph = new Graph<>(nodes, edges);

        DestinationPathCacheFactory destinationPathCacheFactory = new DestinationPathCacheFactory(graph, nodeIndex, destinations);

        this.destinationPathCache = destinationPathCacheFactory.create();
    }

    private List<Node<BlockPos>> buildNodes(Set<Pipe> pipes) {
        return pipes.stream().map(p -> new Node<>(p.getPos())).collect(Collectors.toList());
    }

    public DestinationPathCache getDestinationPathCache() {
        return destinationPathCache;
    }
} 