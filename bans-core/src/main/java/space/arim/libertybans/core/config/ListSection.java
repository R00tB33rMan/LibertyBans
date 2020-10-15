/* 
 * LibertyBans-core
 * Copyright © 2020 Anand Beh <https://www.arim.space>
 * 
 * LibertyBans-core is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * LibertyBans-core is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with LibertyBans-core. If not, see <https://www.gnu.org/licenses/>
 * and navigate to version 3 of the GNU Affero General Public License.
 */
package space.arim.libertybans.core.config;

import space.arim.api.chat.SendableMessage;
import space.arim.api.chat.manipulator.SendableMessageManipulator;

import space.arim.dazzleconf.annote.ConfDefault.DefaultInteger;
import space.arim.dazzleconf.annote.ConfDefault.DefaultString;
import space.arim.dazzleconf.annote.ConfDefault.DefaultStrings;
import space.arim.dazzleconf.annote.ConfHeader;
import space.arim.dazzleconf.annote.ConfKey;
import space.arim.dazzleconf.annote.SubSection;

@ConfHeader("Used for /banlist, /mutelist, /history, /warns, /blame")
public interface ListSection {

	interface PunishmentList {
		
		SendableMessage usage();
		
		int perPage();
		
		SendableMessageManipulator noPages();
		
		SendableMessageManipulator maxPages();
		
		SendableMessage permissionCommand();
		
		SendableMessageManipulator layoutHeader();
		
		SendableMessageManipulator layoutBody();
		
		SendableMessageManipulator layoutFooter();
		
	}
	
	interface BanList extends PunishmentList {
		
		@Override
		@DefaultString("&cUsage: /banlist &e[page]")
		SendableMessage usage();
		
		@Override
		@DefaultInteger(10)
		int perPage();
		
		@Override
		@DefaultString("&7There are no active bans.")
		SendableMessageManipulator noPages();
		
		@Override
		@DefaultString("&7Page &e%PAGE%&7 does not exist. Max pages: &e%MAXPAGE%&7.")
		SendableMessageManipulator maxPages();
		
		@Override
		@ConfKey("permission.command")
		@DefaultString("&7You may not view the banlist.")
		SendableMessage permissionCommand();
		
		@Override
		@ConfKey("layout.header")
		@DefaultStrings({"&7[&eID&7] &e&oSubject",
				"&7Operator &8/ &7Reason &8/ &7Time Remaining",
				"&7"})
		SendableMessageManipulator layoutHeader();
		
		@Override
		@ConfKey("layout.body")
		@DefaultStrings({"&7[&e%ID%&7] &e&o%VICTIM%",
				"&7%OPERATOR% &8/ &7%REASON% &8/ &7%TIME_END_REL%",
				"&7"})
		SendableMessageManipulator layoutBody();
		
		@Override
		@ConfKey("layout.footer")
		@DefaultStrings({"&7Page &e%PAGE%&7/&e%MAXPAGE%&7.||ttp:Click for next page||cmd:/libertybans banlist %NEXTPAGE%"})
		SendableMessageManipulator layoutFooter();
		
	}
	
	interface MuteList extends PunishmentList {
		
		@Override
		@DefaultString("&cUsage: /mutelist &e[page]")
		SendableMessage usage();
		
		@Override
		@DefaultInteger(10)
		int perPage();
		
		@Override
		@DefaultString("&7There are no active mutes.")
		SendableMessageManipulator noPages();
		
		@Override
		@DefaultString("&7Page &e%PAGE%&7 does not exist. Max pages: &e%MAXPAGE%&7.")
		SendableMessageManipulator maxPages();
		
		@Override
		@ConfKey("permission.command")
		@DefaultString("&7You may not view the mutelist.")
		SendableMessage permissionCommand();
		
		@Override
		@ConfKey("layout.header")
		@DefaultStrings({"&7[&eID&7] &e&oSubject",
				"&7Operator &8/ &7Reason &8/ &7Time Remaining",
				"&7"})
		SendableMessageManipulator layoutHeader();
		
		@Override
		@ConfKey("layout.body")
		@DefaultStrings({"&7[&e%ID%&7] &e&o%VICTIM%",
				"&7%OPERATOR% &8/ &7%REASON% &8/ &7%TIME_END_REL%",
				"&7"})
		SendableMessageManipulator layoutBody();
		
		@Override
		@ConfKey("layout.footer")
		@DefaultStrings({"&7Page &e%PAGE%&7/&e%MAXPAGE%&7.||ttp:Click for next page||cmd:/libertybans mutelist %NEXTPAGE%"})
		SendableMessageManipulator layoutFooter();
		
	}
	
	interface History extends PunishmentList {
		
		@Override
		@DefaultString("&cUsage: /history &e<player> [page]")
		SendableMessage usage();
		
		@Override
		@DefaultInteger(10)
		int perPage();
		
		@Override
		@DefaultString("&c&o%TARGET%&r&7 has no history.")
		SendableMessageManipulator noPages();
		
		@Override
		@DefaultString("&7Page &e%PAGE%&7 does not exist. Max pages: &e%MAXPAGE%&7.")
		SendableMessageManipulator maxPages();
		
		@Override
		@ConfKey("permission.command")
		@DefaultString("&7You may not view history.")
		SendableMessage permissionCommand();
		
		@Override
		@ConfKey("layout.header")
		@DefaultStrings({"&7[&eID&7] &r&8/ &7Punishment Type",
				"&7Operator &8/ &7Reason &8/ &7Date Enacted",
				"&7"})
		SendableMessageManipulator layoutHeader();
		
		@Override
		@ConfKey("layout.body")
		@DefaultStrings({"&7[&e%ID%&7] &r&7/ &7%TYPE%",
				"&7%OPERATOR% &8/ &7REASON% &8/ &7%TIME_START_ABS%",
				"&7"})
		SendableMessageManipulator layoutBody();
		
		@Override
		@ConfKey("layout.footer")
		@DefaultStrings({"&7Page &e%PAGE%&7/&e%MAXPAGE%&7.||ttp:Click for next page||cmd:/libertybans history %TARGET% %NEXTPAGE%"})
		SendableMessageManipulator layoutFooter();
		
	}
	
	interface Warns extends PunishmentList {
		
		@Override
		@DefaultString("&cUsage: /warns &e<player> [page]")
		SendableMessage usage();
		
		@Override
		@DefaultInteger(10)
		int perPage();
		
		@Override
		@DefaultString("&c&o%TARGET%&r&7 has no warns.")
		SendableMessageManipulator noPages();
		
		@Override
		@DefaultString("&7Page &e%PAGE%&7 does not exist. Max pages: &e%MAXPAGE%&7.")
		SendableMessageManipulator maxPages();
		
		@Override
		@ConfKey("permission.command")
		@DefaultString("&7You may not view warns.")
		SendableMessage permissionCommand();
		
		@Override
		@ConfKey("layout.header")
		@DefaultStrings({"&7[&eID&7] Operator &8/ &7Reason &8/ &7Time Remaining",
				"&7"})
		SendableMessageManipulator layoutHeader();
		
		@Override
		@ConfKey("layout.body")
		@DefaultStrings({"&7[&e%ID%&7] %OPERATOR% &8/ &7%REASON% &8/ &7%TIME_END_REL%",
				"&7"})
		SendableMessageManipulator layoutBody();
		
		@Override
		@ConfKey("layout.footer")
		@DefaultStrings({"&7Page &e%PAGE%&7/&e%MAXPAGE%&7.||ttp:Click for next page||cmd:/libertybans warns %TARGET% %NEXTPAGE%"})
		SendableMessageManipulator layoutFooter();
		
	}
	
	interface Blame extends PunishmentList {
		
		@Override
		@DefaultString("&cUsage: /blame &e<player> [page]")
		SendableMessage usage();
		
		@Override
		@DefaultInteger(10)
		int perPage();
		
		@Override
		@DefaultString("&c&o%TARGET%&r&7 has not punished any players.")
		SendableMessageManipulator noPages();
		
		@Override
		@DefaultString("&7Page &e%PAGE%&7 does not exist. Max pages: &e%MAXPAGE%&7.")
		SendableMessageManipulator maxPages();
		
		@Override
		@ConfKey("permission.command")
		@DefaultString("&7You may not use blame.")
		SendableMessage permissionCommand();
		
		@Override
		@ConfKey("layout.header")
		@DefaultStrings({"&7[&eID&7] &e&oSubject &r&8/ &7Punishment Type",
				"&7Reason &8/ &7Date Enacted",
				"&7"})
		SendableMessageManipulator layoutHeader();
		
		@Override
		@ConfKey("layout.body")
		@DefaultStrings({"&7[&e%ID%&7] &e&o%SUBJECT% &r&8 / &7%TYPE%",
				"&7%REASON% &8/ &7%TIME_START_ABS%",
				"&7"})
		SendableMessageManipulator layoutBody();
		
		@Override
		@ConfKey("layout.footer")
		@DefaultStrings({"&7Page &e%PAGE%&7/&e%MAXPAGE%&7.||ttp:Click for next page||cmd:/libertybans warns %TARGET% %NEXTPAGE%"})
		SendableMessageManipulator layoutFooter();
		
	}
	
	enum ListType {
		BANLIST,
		MUTELIST,
		HISTORY,
		WARNS,
		BLAME;
	}
	
	default PunishmentList forType(ListType type) {
		switch (type) {
		case BANLIST:
			return banList();
		case MUTELIST:
			return muteList();
		case HISTORY:
			return history();
		case WARNS:
			return warns();
		case BLAME:
			return blame();
		default:
			throw new IllegalArgumentException("Unknown list type " + type);
		}
	}
	
	@SubSection
	BanList banList();
	
	@SubSection
	MuteList muteList();
	
	@SubSection
	History history();
	
	@SubSection
	Warns warns();
	
	@SubSection
	Blame blame();
	
}