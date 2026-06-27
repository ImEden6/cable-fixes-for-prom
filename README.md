# Cable Fixes for Prom

A Fabric mod that fixes nested transaction crashes in **Ad Astra** machines when interacting with external fluid or item pipes (like those from Pipez or other transport mods).

## 🚀 Features
- **Nested Transaction Fix**: Prevents the `IllegalStateException: Transaction already in progress` crash when machines attempt to process internal transactions while an external pipe is already holding an open transaction.
- **Improved Compatibility**: Makes Ad Astra machines work reliably with a wider variety of item/fluid transport systems.

## 🛠️ How it Works
This mod uses Sponge Mixins to wrap `MachineFluidTransactionMixin` and (if applicable) item transactions, ensuring they only attempt to open a transaction if one isn't already active, or by delegating to the existing transaction context.

## 📦 Installation
1. Install the [Fabric Loader](https://fabricmc.net/).
2. Add this `.jar` to your `mods` folder.
3. Requires **Ad Astra** and its dependencies.

## 📜 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
