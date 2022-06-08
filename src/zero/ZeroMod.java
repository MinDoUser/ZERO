package zero;
import arc.*;
import arc.scene.ui.layout.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.ui.*;
import mindustry.graphics.*;

import zero.ui.dialogs.*;
import zero.function.*;
import zero.content.*;

public class ZeroMod extends Mod{
	//public static final AboutModDialog modDialog = new AboutModDialog();
	
	public static final String MOD_NAME = "zero"; // Mod name.
	/** Creates a new String wich contains the mod name. */
	public static String getName(String str){
		return MOD_NAME+"-"+str;
	}
  public ZeroMod(){
	  //Object of mod is created when loaded into the Mods dialog...

	  Events.on(ClientLoadEvent.class, e -> {
		  new ZContent().load(); // Load here cuz we need it soon...
		  ZSettings.updateSettings();
		  //modDialog.show();
    		startScreen();
	  });
  }
	public static void startScreen(){
		/*BaseDialog dialog = new BaseDialog("Welcome");
		dialog.closeOnBack();
		dialog.cont.pane(inner -> {
			inner.pane(table -> {
				table.pane(p -> {
					p.image(ZContent.logo).row();
					p.row();
					p.image().growX().pad(5).padLeft(0).padRight(0).height(5).color(ZColor.white);
					p.row();
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
	dialog.show();*/
		BaseDialog dialog = new BaseDialog("Startscreen");
		dialog.cont.pane(inner -> {
			inner.pane(table -> {
				table.pane(p -> {
					p.image(ZContent.logo).row();
					p.row();
					p.image().growX().pad(5).padLeft(0).padRight(0).height(5).color(ZColor.white);
					p.row();
					p.add(new Bar()).growX();
					p.row();
					p.add("[white]<<< Z E R O >>>", Styles.techLabel).row();
					p.row();
					p.add(new Bar()).growX();
				}).fillY().growX().row();
				table.add("").row();
			}).growX().center().row();
			
			inner.table(table -> {
				table.table(t -> {
					t.add("A mod made by: lol02\nIt adds some new blocks and features.\n\n I hope you like them!");
					t.row();
					t.row();
					t.button("< Ok! >", dialog::hide).size(200f, 100f);
				}).grow();
			}).fill();
		}).grow();
		dialog.show();
}
	/*public void createButton(){
		Table buttonTable1;
		//Table buttonTable2;
		buttonTable1 = new Table();
		buttonTable1.button("Mod Info", Icon.info,()->{
			modDialog.show();
		}).get().setSize(150, 75);
		//buttonTable2 = buttonTable1(); //To get 2 different tabled.
		
		Table screenTable = Core.scene.table();
		screenTable.bottom().left().add(buttonTable1);
	}*/
@Override
public void loadContent(){
	new ZItems().load();
	new ZBullets().load();
	new ZBlocks().load();
        Log.info("Loaded all Java files.");
    }
}
  
