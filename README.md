# Redefined Pipes

[![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-green.svg)](https://minecraft.net/)
[![NeoForge](https://img.shields.io/badge/NeoForge-21.1.176+-blue.svg)](https://neoforged.net/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A modern pipe system mod for Minecraft that adds various types of pipes for transporting items, fluids, and energy. Built for **NeoForge 1.21.1** with optional JEI and Jade integration.

## 📖 About

**Redefined Pipes** adds comprehensive pipe systems to Minecraft for transporting items, fluids, and energy. Create complex automation networks with smart routing, visual transport animations, and configurable attachments.

### 🔄 Origin

This project is based on the original [Refined Pipes](https://github.com/refinedmods/refinedpipes) mod by **RefinedMods**, completely rewritten for modern NeoForge with enhanced features and performance improvements.

## ✨ Features

### 🚰 Pipe Systems
- **Item Pipes** (Basic, Improved, Advanced)
  - Smart item routing with priorities
  - Visual item transport animations
  - Timing modifiers (entry delay, exit acceleration)
- **Fluid Pipes** (Basic, Improved, Advanced, Elite, Ultimate)
  - Fluid transport with visual fill level indicators
  - Various capacities and transfer rates
- **Energy Pipes** (Basic, Improved, Advanced, Elite, Ultimate)
  - Energy transport (FE/RF compatible)
  - Configurable capacities and transfer rates

### 🔧 Attachments
- **Extractor Attachments** (5 tiers: Basic → Ultimate)
  - Extract items and fluids from inventories
  - Configurable filters (whitelist/blacklist)
  - Redstone modes (ignore, high signal, low signal)
  - Routing modes (nearest, furthest, random, round robin)
  - Stack size configuration
  - Exact mode for precise item matching

### 🎨 Rendering & Visuals
- **Dynamic 3D Models**: Pipes connect intelligently
- **Item Transport Animation**: Rotating items visible in pipes
- **Fluid Visualization**: Animated fluid levels in pipes
- **Attachment Rendering**: Full 3D representation of all attachments

### 🔌 Integrations
- **JEI Support**: Just Enough Items integration
  - Fluid rendering in GUIs
  - Proper tooltips for fluid filters
  - Plugin registration for future expansions
- **Jade Support**: Advanced tooltip information
  - Real-time energy storage display
  - Transfer rate information
  - Clean, organized tooltip layout

## 🚀 Installation

### For Players
1. Install **NeoForge 21.1.176+** for Minecraft 1.21.1
2. Download the latest Refined Pipes `.jar` file from [Releases](../../releases)
3. Place it in your `mods/` folder
4. *(Optional)* Install compatible mods for enhanced features:
   - [JEI](https://www.curseforge.com/minecraft/mc-mods/jei) for enhanced GUI features
   - [Jade](https://modrinth.com/mod/jade) for advanced tooltip information

### For Developers
See [DEVELOPMENT.md](DEVELOPMENT.md) for detailed development setup and technical information.

## 🎮 Usage

### Basic Setup
1. **Place pipes** in the world - they auto-connect to compatible blocks
2. **Add attachments** by right-clicking pipes with attachment items
3. **Configure extractors** by right-clicking placed attachments

### Item Transport
- Items are automatically routed based on available destinations
- Priority order: Nearest → Furthest → Random → Round Robin
- Visual animations show transport status in real-time

### Fluid & Energy
- Pipes automatically balance fluid/energy levels across the network
- Visual indicators show current fill levels and flow direction

### Mod Integrations
- **JEI (Just Enough Items)**
  - Enhanced fluid rendering in GUI screens
  - Proper tooltips for fluid filters
  - Recipe integration for future expansions
- **Jade (Hwyla successor)**
  - Real-time energy storage information
  - Transfer rate display for energy pipes
  - Clean, organized tooltip layout

## 🔧 Requirements

- **Minecraft**: 1.21.1
- **NeoForge**: 21.1.176 or higher

### Optional Mods
- **[JEI](https://www.curseforge.com/minecraft/mc-mods/jei)**: Enhanced GUI features
- **[Jade](https://modrinth.com/mod/jade)**: Advanced tooltips

## 🤝 Contributing

We welcome contributions! For detailed development information, see [DEVELOPMENT.md](DEVELOPMENT.md).

Quick start:
1. **Fork** the repository
2. **Create** a feature branch
3. **Test** thoroughly
4. **Open** a Pull Request

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

## 🙏 Credits

- **Original Mod**: [RefinedMods Team](https://github.com/refinedmods) - creators of Refined Pipes
- **NeoForge Port**: [smallinger](https://github.com/smallinger) - complete rewrite for NeoForge 1.21.1
- **Community**: Thanks to all testers and contributors

## 📞 Support

- **🐛 Bug Reports**: [GitHub Issues](../../issues)
- **💡 Feature Requests**: [GitHub Discussions](../../discussions)
- **🔧 Development**: See [DEVELOPMENT.md](DEVELOPMENT.md)
- **🔗 Original Mod**: [Refined Pipes on CurseForge](https://www.curseforge.com/minecraft/mc-mods/refined-pipes)

## 📊 Status

| Feature | Status | Notes |
|---------|--------|-------|
| Item Pipes | ✅ Complete | All tiers, full functionality |
| Fluid Pipes | ✅ Complete | All tiers, visual indicators |
| Energy Pipes | ✅ Complete | All tiers, FE/RF support |
| Extractors | ✅ Complete | All configurations working |
| 3D Rendering | ✅ Complete | Dynamic models, animations |
| JEI Integration | ✅ Complete | Fluid rendering, tooltips |
| Jade Integration | ✅ Complete | Energy tooltips, transfer rates |
| Multiplayer | ✅ Complete | Full sync, tested |
| Save Migration | ✅ Complete | From Forge version |

---

<div align="center">

**⭐ If you find this project useful, please consider giving it a star! ⭐**

Made with ❤️ for the Minecraft modding community

</div>
