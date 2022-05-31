package zero.ui.dialogs;

import arc.*;
import arc.scene.ui.*;
import arc.util.*;
import mindustry.core.GameState.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.ui.Styles;
import mindustry.ui.dialogs.BaseDialog;

public class AboutModDialog extends BaseDialog{
	public AboutModDialog(){
		super("About Mod");
		this.cont.pane(inner -> {
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
	}
}
