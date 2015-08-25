package com.zigolive.plugin;

public interface IPluginArch {
/**
 * Get an instance of the plugin arch, that is specific to 
 * the current application name
 * @param name application name
 * @return
 */
	public IPluginArch getApplicationInstance(String name);
	public void registerPlugin(String plugin);
}
