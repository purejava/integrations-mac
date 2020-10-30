package org.cryptomator.macos.autostart;

import org.cryptomator.integrations.autostart.AutoStartProvider;
import org.cryptomator.integrations.autostart.ToggleAutoStartFailedException;

public class MacAutoStartProvider implements AutoStartProvider {

	private final MacLaunchServices launchServices;

	public MacAutoStartProvider() {
		this.launchServices = new MacLaunchServices();
	}

	@Override
	public void enable() throws ToggleAutoStartFailedException {
		if (!this.launchServices.enableLoginItem()) {
			throw new ToggleAutoStartFailedException("Enabling auto start failed.");
		}
	}

	@Override
	public void disable() throws ToggleAutoStartFailedException {
		if (!this.launchServices.disableLoginItem()) {
			throw new ToggleAutoStartFailedException("Disabling auto start failed.");
		}
	}

	@Override
	public boolean isEnabled() {
		return this.launchServices.isLoginItemEnabled();
	}

}
