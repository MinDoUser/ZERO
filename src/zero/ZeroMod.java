package zero;
import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.ui.Styles;

import zero.ui.dialogs.*;
import zero.function.*;
import zero.content.*;

public class ZeroMod extends Mod{
	public static final String MOD_NAME = "zero"; // Mod name.
	/** Creates a new String wich contains the mod name. */
	public static String getName(String str){
		return MOD_NAME+"-"+str;
	}
  public ZeroMod(){
	  //Object of mod is created when loaded into the Mods dialog...

	  Events.on(ClientLoadEvent.class, e -> {
		  ZSettings.updateSettings();
    		startScreen();
	  });
  }
	public static void startScreen(){
		BaseDialog dialog = new BaseDialog("Welcome");
		dialog.closeOnBack();
		dialog.cont.pane(inner -> {
			inner.pane(table -> {
				table.pane(p -> {
					p.add("[white]<<< Z E R O >>>", Styles.techLabel).row();
				}).fillY().growX().row();
				table.add("").row();
			}).growX().center().row();
			
			inner.table(table -> {
				table.table(t -> {
					t.add("$dialogs.welcomeText");
					t.row();
					t.row();
					t.button("< Ready >", dialog::hide).size(150f, 100f);
				}).grow();
			}).fill();
		}).grow();
	dialog.show();
}
@Override
public void loadContent(){
	new ZItems().load();
	new ZBullets().load();
	new ZBlocks().load();
        Log.info("Loaded all Java files.");
    }
}
  
