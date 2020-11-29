# FurnaceExpFarmLimiter
Spigot plugin allows configure furnace recipes for limiting experience farms.

```
# FurnaceExpFarmLimiter
# Plugin created by kovalski
config-version: 1.0

# Plugin Prefix for messages. Usage %prefix%
prefix: "&b[FurnaceExpFarmLimiter]"

# Debug messages
debug: true

# Experience settings based input material
# Give feedback for better values Thanks!
# The experience values of the recipes are very different from each other.
# You can learn which item how much exp earned on smelting. Use /expitem command.
#
# recipes:
#   stone_furnace:
#     CACTUS: 0.1
#     COBBLESTONE: 0.1
#     KELP: 0.1
#   blast_furnace:
#     REDSTONE_ORE: 0.7
#   smoker:
#     KELP: 0.1
#   camp_fire:
#     KELP: 0.1

recipes:
  stone_furnace:
    CACTUS: 0.1
    COBBLESTONE: 0.1
    KELP: 0.1
  blast_furnace:
    REDSTONE_ORE: 0.7
  smoker:
    KELP: 0.1
  camp_fire:
    KELP: 0.1

# Plugin Messages
# You can disable it by leaving the blank message ""
messages:
  msg_reload: "%prefix% &aReloaded"
  usage_fefl: "&aUsage: /FurnaceExpFarmLimiter reload"
  error_no_permission: "%prefix% &cYou don't have permission for use this command!"
  error_no_item: "%prefix% &cHold item before using the command.
```
