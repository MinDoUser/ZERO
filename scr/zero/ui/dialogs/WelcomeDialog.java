package zero.ui.dialogs;

import mindustry.ui.dialogs.*;

public class WelcomeDialog extends BaseDialog{
    public WelcomeDialog(){
      super("@dialog.welcome");
      
      //addCloseButton();
    }
  public void show(){
    closeOnBack();
		this.cont.pane(inner -> {
			inner.pane(table -> {
				table.pane(p -> {
					p.add("[white]<<< Z E R O >>>", Styles.techLabel).row();
				}).fillY().growX().row();
				table.add("").row();
			}).growX().center().row();
			
			inner.table(table -> {
				table.table(t -> {
					t.add("@dialog.welcome.text");
					t.row();
					t.button("< Ready >", dialog::hide).size(150f, 100f);
				}).grow();
			}).fill();
		}).grow();
  }
}
