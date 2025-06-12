# Development Guide - Redefined Pipes

[![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-green.svg)](https://minecraft.net/)
[![NeoForge](https://img.shields.io/badge/NeoForge-21.1.176+-blue.svg)](https://neoforged.net/)
[![Java](https://img.shields.io/badge/Java-21+-orange.svg)](https://openjdk.java.net/)

This document contains technical information for developers working on Redefined Pipes.

## 🔧 Technical Requirements

### Version Requirements
- **Minecraft**: 1.21.1
- **NeoForge**: 21.1.176 or higher
- **Java**: 21 or higher

### Optional Dependencies
- **JEI**: 19.20.0.239+ (enhanced GUI features)
- **Jade**: 15.10.0+ (advanced tooltips)

## 🏗️ Development Setup

### Building
```bash
# Clone the repository
git clone https://github.com/smallinger/RedefinedPipes.git
cd RedefinedPipes/neoforge

# Set up development environment
./gradlew build

# Run client with optional mods
./gradlew runClient

# Run server
./gradlew runServer

# Run tests
./gradlew test
```

### Project Structure
```
src/main/java/com/github/smallinger/redefinedpipes/
├── block/              # Pipe blocks
├── blockentity/        # Block entities
├── item/               # Items and block items
├── menu/               # Container menus
├── network/            # Pipe network logic
├── render/             # Client-side rendering
├── screen/             # GUI screens
├── integration/        # Mod integrations
│   ├── jei/            # JEI integration
│   └── jade/           # Jade integration
├── setup/              # Mod setup and registration
└── util/               # Utility classes
```

## 🔄 Key API Migrations (Forge → NeoForge)

### Registry System
```java
// Old (Forge)
@ObjectHolder("redefinedpipes:basic_item_pipe")
public static final Block BASIC_ITEM_PIPE = null;

// New (NeoForge)
public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
public static final DeferredBlock<ItemPipeBlock> BASIC_ITEM_PIPE = BLOCKS.register("basic_item_pipe", ...);
```

### Capabilities → Data Attachments
```java
// Old (Forge)
LazyOptional<IItemHandler> cap = blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);

// New (NeoForge)
IItemHandler handler = level.getCapability(Capabilities.ItemHandler.BLOCK, pos, direction);
```

### Networking
```java
// Old (Forge)
SimpleChannel channel = NetworkRegistry.newSimpleChannel(...);

// New (NeoForge)
public record MyMessage(...) implements CustomPacketPayload {
    public static final StreamCodec<ByteBuf, MyMessage> STREAM_CODEC = ...;
}
```

### Event System
```java
// Old (Forge)
@SubscribeEvent
public void onBlockBreak(BlockEvent.BreakEvent event) { ... }

// New (NeoForge)
@SubscribeEvent
public void onBlockBreak(BlockEvent.BreakEvent event) { ... } // Same API
```

## 🧪 Testing

### Unit Tests
```bash
# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests "com.github.smallinger.redefinedpipes.network.*"
```

### Integration Testing
- Test in both single-player and multiplayer environments
- Verify compatibility with JEI and Jade when present
- Test save/load compatibility with original Forge version

## 🔌 Mod Integration Development

### JEI Integration
Located in `src/main/java/com/github/smallinger/redefinedpipes/integration/jei/`

Key classes:
- `RedefinedPipesJEIPlugin`: Main JEI plugin registration
- `FluidFilterGhostIngredientHandler`: Handles fluid ghost ingredients

### Jade Integration
Located in `src/main/java/com/github/smallinger/redefinedpipes/integration/jade/`

Key classes:
- `RedefinedPipesJadePlugin`: Main Jade plugin registration
- `EnergyPipeComponentProvider`: Provides energy pipe tooltip data

## 📊 Performance Considerations

### Network Optimization
- Pipe networks are calculated server-side only
- Client receives minimal sync data for rendering
- Network updates are batched and throttled

### Rendering Optimization
- Dynamic models are cached per connection state
- Item transport animations use efficient particle-like rendering
- Fluid rendering uses texture atlasing for performance

## 🐛 Debugging

### Debug Commands
```bash
# Enable debug logging
-Dredefinedpipes.debug=true

# Network debugging
-Dredefinedpipes.network.debug=true

# Rendering debugging
-Dredefinedpipes.render.debug=true
```

### Common Issues
1. **Pipes not connecting**: Check block state properties
2. **Items not flowing**: Verify network calculation logic
3. **Rendering issues**: Check model cache invalidation

## 🤝 Contributing Guidelines

### Code Style
- Follow existing code patterns and naming conventions
- Use meaningful variable and method names
- Add JavaDoc comments for public APIs
- Keep methods focused and single-purpose

### Pull Request Process
1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/amazing-feature`)
3. **Test** thoroughly in both single-player and multiplayer
4. **Document** any new features or API changes
5. **Commit** with clear, descriptive messages
6. **Push** to your fork and create a Pull Request

### Testing Requirements
- All new features must include appropriate tests
- Existing tests must continue to pass
- Test compatibility with both JEI and Jade integrations
- Verify save/load compatibility

## 📈 Performance Benchmarks

### Network Performance
- Target: <1ms per network update for networks up to 1000 pipes
- Memory: <10MB for large networks (5000+ pipes)
- Sync frequency: 20 ticks for visual updates, immediate for state changes

### Rendering Performance
- Target: 60+ FPS with 100+ visible pipes
- Model cache hit rate: >95%
- Texture memory: <50MB for all pipe textures

## 🔍 Architecture Overview

### Network System
The pipe network system is built around these core concepts:

1. **NetworkManager**: Central coordinator for all pipe networks
2. **PipeNetwork**: Represents a connected group of pipes
3. **Pipe**: Individual pipe logic (item/fluid/energy specific)
4. **Attachment**: Extractors and other pipe attachments

### Data Flow
1. Player places/breaks pipes → Network recalculation
2. Items/fluids enter network → Routing calculation
3. Transport simulation → Visual updates
4. Client rendering → Smooth animations

## 📚 Additional Resources

- [NeoForge Documentation](https://docs.neoforged.net/)
- [JEI API Documentation](https://github.com/mezz/JustEnoughItems/wiki)
- [Jade API Documentation](https://jademc.readthedocs.io/)
- [Original Refined Pipes](https://github.com/refinedmods/refinedpipes)

---

For user-focused information, see [README.md](README.md). 