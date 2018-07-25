package me.F64.papiexpansions.playtime;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import me.F64.PlayTime.Utils.TimeFormat;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class ExpansionPlayTime extends PlaceholderExpansion {
	public boolean canRegister() {
		return Bukkit.getPluginManager().getPlugin(getPlugin()) != null;
	}

	public String getAuthor() {
		return "F64_Rx";
	}

	public String getIdentifier() {
		return "playtime";
	}

	public String getPlugin() {
		return "PlayTime";
	}

	public String getVersion() {
		return "1.0";
	}

	public String onPlaceholderRequest(Player p, String identifier) {
		if (p == null) {
			return "";
		}
		if (identifier.equals("player")) {
			return String.valueOf(p.getName());
		}
		if (identifier.equals("time")) {
			return String.valueOf(TimeFormat.getTime(p.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20));
		}
		if (identifier.equals("timesjoined")) {
			return String.valueOf(p.getStatistic(Statistic.LEAVE_GAME) + 1);
		}
		if (identifier.equals("serveruptime")) {
			return String.valueOf(TimeFormat.Uptime());
		}
		return null;
	}
}