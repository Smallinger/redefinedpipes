package com.github.smallinger.redefinedpipes.network;

import com.github.smallinger.redefinedpipes.network.graph.NetworkGraph;
import com.github.smallinger.redefinedpipes.network.graph.NetworkGraphScannerResult;
import com.github.smallinger.redefinedpipes.network.pipe.Destination;
import com.github.smallinger.redefinedpipes.network.pipe.DestinationType;
import com.github.smallinger.redefinedpipes.network.pipe.Pipe;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import java.util.List;

public abstract class Network {
    protected final NetworkGraph graph = new NetworkGraph(this);
    private final String id;
    private BlockPos originPos;
    private boolean didDoInitialScan;

    public Network(BlockPos originPos, String id) {
        this.id = id;
        this.originPos = originPos;
    }

    public void setOriginPos(BlockPos originPos) {
        this.originPos = originPos;
    }

    public String getId() {
        return id;
    }

    public NetworkGraphScannerResult scanGraph(Level level, BlockPos pos) {
        return graph.scan(level, pos);
    }

    public List<Destination> getDestinations(DestinationType type) {
        return graph.getDestinations(type);
    }

    public CompoundTag writeToNbt(CompoundTag tag) {
        tag.putString("id", id);
        tag.putLong("origin", originPos.asLong());

        return tag;
    }

    public void update(Level level) {
        if (!didDoInitialScan) {
            didDoInitialScan = true;

            scanGraph(level, originPos);
        }

        graph.getPipes().forEach(Pipe::update);
    }

    public Pipe getPipe(BlockPos pos) {
        return graph.getPipes().stream().filter(p -> p.getPos().equals(pos)).findFirst().orElse(null);
    }

    public abstract void onMergedWith(Network mainNetwork);

    public abstract ResourceLocation getType();
} 