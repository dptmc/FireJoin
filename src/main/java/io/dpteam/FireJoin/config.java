package io.dpteam.FireJoin;

import org.bukkit.configuration.file.FileConfiguration;

public class config {
	public static Integer configPower = 1;
	public static Integer loginDelay = 20;
	FileConfiguration file;

	public config() {
		super();
	}

	public void load() {
		this.file = Main.getPlugin().getConfig();
		if (!this.file.contains("power")) {
			this.file.set("power", configPower);
		}

		configPower = this.file.getInt("power");
		if (!this.file.contains("logindelay")) {
			this.file.set("logindelay", loginDelay);
		}

		loginDelay = this.file.getInt("logindelay");
		this.letsSAVEthisShit();
	}

	public void setPower(Integer power) {
		configPower = power;
		this.file.set("power", power);
		this.letsSAVEthisShit();
	}

	public void setloginDelay(Integer _loginDelay) {
		loginDelay = _loginDelay;
		this.file.set("logindelay", loginDelay);
		this.letsSAVEthisShit();
	}

	public void letsSAVEthisShit() {
		Main.getPlugin().saveConfig();
	}
}
