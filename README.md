# Balisong Spin (Fabric 1.21.8)

A starter Fabric mod adding a Butterfly Knife item. Hold it and press **R** to toggle a continuous flip animation; press **R** again to stop.

## Requirements
- Minecraft Java Edition 1.21.8
- Java 21
- Fabric Loader and Fabric API
- Gradle (or use the included Gradle wrapper if you add one)

## Build
From this folder run:

```sh
gradle build
```

The mod jar will be in `build/libs/`.

## Install
Copy `build/libs/balisong-spin-1.0.0.jar` into your Minecraft `mods` folder alongside Fabric API.

## Current scope
This is a starter implementation: the item model is a generated 2D sprite and the animation rotates the held item. A polished balisong with separate folding handles, hand-aware finger tricks, and custom sounds would need a 3D model and a more advanced renderer.
