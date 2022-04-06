package zero.function;

import mindustry.ui.dialogs.*;
import mindustry.ui.Styles;
import mindustry.Vars;

import zero.ui.dialogs.*;

import arc.Core;

import static mindustry.Vars.ui;

public class ZSettings{
 public void updateSettings(){
	SettingsMenuDialog settings = Vars.ui.settings;
	settings.graphics.row();
	 settings.add("[white]MOD SETTINGS", Styles.techLabel);
	settings.graphics.checkPref("overridecontentdialog", true, b -> {
	Log.info("Boolean: "+b);
	Vars.ui.content = b?new ContentInfoOverride(): new ContentInfoDialog();
	});
 }
}