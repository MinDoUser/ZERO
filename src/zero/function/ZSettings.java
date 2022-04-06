package zero.function;

import mindustry.ui.dialogs.*;
import mindustry.ui.Styles;

import static mindustry.Vars.ui;

public class ZSettings{
  public static boolean overrideInfoDialog = false;
  
  public static void updateSettings(boolean shouldUpdate){
    SettingsMenuDialog settings = Vars.ui.settings;
		
		settings.graphics.row();
    settings.graphics.add("[stat]MOD:", Styles.techLabel);
    settings.graphics.row();
		setting.graphics.checkPref("overridecontentdialog", true); //Not much so far...
    
    if(shouldUpdate) update();
  }
  public static void update(){
    overrideInfoDialog = Core.settings.getBool("overridecontentdialog");
  }
}
