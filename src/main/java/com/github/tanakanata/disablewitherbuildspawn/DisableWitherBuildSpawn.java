package com.github.tanakanata.disablewitherbuildspawn;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class DisableWitherBuildSpawn extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void onCreatureSpawnEvent(CreatureSpawnEvent event) {
        //スポーンしたMOBがウィザーか判定
        if(event.getEntity().getType() != EntityType.WITHER) {
            return;
        }
        //スポーン理由がBUILD_WITHERか判定
        if (event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.BUILD_WITHER) {
            return;
        }
        event.setCancelled(true);
        Bukkit.broadcastMessage("§e[DWBS]§cこのワールドでは召喚できません。");
    }

}
