# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.1.0] - 2026-06-27

### Added
- **Create & AE2 Compatibility Mixin**: Implemented `RenderAttachedBlockView` on Create's `FilteredBlockAndTintGetter` via [FilteredBlockAndTintGetterMixin.java](file:///d:/projects/ad-astra-cable-fix/src/main/java/com/mervyn/adastracablefix/mixin/FilteredBlockAndTintGetterMixin.java) to resolve `ClassCastException` crashes when copycat blocks query Applied Energistics 2 cables and busses for appearance data.
- **Copycat Material Acceptance**: Implemented a Mixin [CopycatBlockMixin.java](file:///d:/projects/ad-astra-cable-fix/src/main/java/com/mervyn/adastracablefix/mixin/CopycatBlockMixin.java) on Create's `CopycatBlock.getAcceptedBlockState` to bypass entity block and voxel shape checks for AE2 cables and busses, allowing them to be accepted as copycat materials.
- **Conditional Loading**: Introduced [AdAstraCableFixMixinConfigPlugin.java](file:///d:/projects/ad-astra-cable-fix/src/main/java/com/mervyn/adastracablefix/mixin/AdAstraCableFixMixinConfigPlugin.java) to conditionally apply the compatibility mixins only when both `create` and `ae2` mods are present.
- **Compilation Stubs**: Added local stub classes for `FilteredBlockAndTintGetter` and `CopycatBlock` under the main source set to satisfy Mixin target verification during compilation without needing Create as a compile dependency.

### Changed
- Mod name updated from "Ad Astra Cable Fix" to "Cable Fixes for Prom".

### Removed
- Excluded compiler stub classes from final packaged jars to keep the distribution clean.
