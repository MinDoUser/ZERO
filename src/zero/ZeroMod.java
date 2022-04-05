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
//Yep, it's not the best name, but everthing else just didn't work...
public class ZeroMod extends Mod{
  public ZeroMod(){
    startScreen();
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
					t.button("< Ready >", dialog::hide).size(150f, 100f);
				}).grow();
			}).fill();
		}).grow();
	dialog.show();
}
@Override
public void loadContent(){
        Log.info("Loaded all Java files.");
    }
}
  
