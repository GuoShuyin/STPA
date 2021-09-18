package me.gsy.stpa;

import org.bukkit.plugin.java.JavaPlugin;




public final class STPA extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        // All you have to do is adding the following two lines in your onEnable method.
        MetricsLite metrics = new MetricsLite(this);
       // metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));

        // Optional: Add custom charts

        //metrics.addCustomChart(new MetricsLite().SimplePie("chart_id", () -> "My value"));
        System.out.println("{GSY} STPA插件已加载");
        getCommand("tpa").setExecutor(new tpa());
        getCommand("tpahere").setExecutor(new tpahere());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
