# Cable Fixes for Prom

A Fabric mod that fixes various mod-interactivity crashes and issues on the Prominence 2 modpack, specifically focusing on **Ad Astra** machines and **Create** / **Applied Energistics 2** copycat blocks.

## 🚀 Features

- **Nested Transaction Fix (Ad Astra)**: Prevents the `IllegalStateException: Transaction already in progress` crash when external fluid/item pipes (like those from Pipez or other transport mods) interact with Ad Astra machines while an internal transaction is active.
- **Create & AE2 Compatibility**: Resolves `ClassCastException` crashes when Create's Copycat blocks query AE2 cables and busses for appearance data by implementing `RenderAttachedBlockView` on Create's `FilteredBlockAndTintGetter`.
- **Copycat Material Acceptance**: Bypasses voxel shape and entity checks for AE2 cables and busses, allowing them to be accepted and used as copycat materials.
- **Conditional Loading**: Compatibility mixins for Create and AE2 are only applied if both mods are active in the environment, preventing class loading issues.

## 🛠️ How it Works

- **Ad Astra Fixes**: Sponge Mixins hook into the machine block entities (`updateSlots`) and defer fluid/item updates to the tail end of the server tick if an active transaction is open.
- **Create & AE2 Fixes**: Implements Fabric's `RenderAttachedBlockView` on Create's `FilteredBlockAndTintGetter` to delegate render attachment queries. A mixin on `CopycatBlock.getAcceptedBlockState` handles material checks for AE2's `CableBusBlock` to accept them as valid copycat blocks.

## 📦 Installation

1. Install the [Fabric Loader](https://fabricmc.net/).
2. Add this `.jar` to your `mods` folder.
3. Requires **Ad Astra** as a hard dependency. **Create** and **Applied Energistics 2** are optionally supported (compatibility features load automatically if both are present).

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

