package io.dpteam.PluginName;

import java.util.Random;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.inventory.meta.FireworkMeta;

public class utils {
	public utils() {
		super();
	}

	public static FireworkMeta getRandomFire(FireworkMeta currMeta) {
		Random r = new Random();
		int number = r.nextInt(3);
		switch(number) {
		case 0:
			currMeta.addEffect(FireworkEffect.builder().flicker(false).trail(true).with(Type.BALL_LARGE).withColor(Color.RED).withColor(Color.BLUE).withFade(Color.GREEN).build());
			break;
		case 1:
			currMeta.addEffect(FireworkEffect.builder().flicker(false).trail(true).with(Type.CREEPER).withColor(Color.RED).withColor(Color.RED).withFade(Color.FUCHSIA).build());
			break;
		case 2:
			currMeta.addEffect(FireworkEffect.builder().flicker(true).trail(true).with(Type.BURST).withColor(Color.LIME).withColor(Color.BLUE).withFade(Color.GRAY).build());
			break;
		case 3:
			currMeta.addEffect(FireworkEffect.builder().flicker(false).trail(true).with(Type.STAR).withColor(Color.ORANGE).withColor(Color.AQUA).withFade(Color.YELLOW).build());
		}

		currMeta.setPower(config.configPower);
		return currMeta;
	}
}
