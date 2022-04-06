package zero.ui.dialogs;

import arc.*;
import arc.scene.ui.*;
import arc.scene.ui.layout.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ctype.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.meta.*;
import mindustry.ui.dialogs.*;
import mindustry.ui.Styles;

import static mindustry.Vars.*;

public class ContentInfoOverride extends ContentInfoDialog{
  public ContentInfoOverride(){
    super(); //Call superclass constructor.
  }
  @Override
  public void show(UnlockableContent content){ // Same as in other files with some little changes...
        cont.clear();

        Table table = new Table();
        table.margin(10);

        //initialize stats if they haven't been yet
        content.checkStats();

        table.table(title1 -> {
          String contentName = content.localizedName;
          //Replace "ä", "ö", "ü", cuz they result crap in the techLabel Style...
          Log.info("Content Name: "+contentName);
          contentName = contentName.replace("ü", "ue");
          contentName = contentName.replace("ö", "oe");
          contentName = contentName.replace("ä", "ae");
          Log.info("Content Name After: "+contentName);
            title1.image(content.uiIcon).size(iconXLarge).scaling(Scaling.fit);
            title1.row(); // New row
            title1.row(); //Next row 2
            title1.add("[accent]" + contentName, Styles.techLabel).padLeft(5);
          title1.row();
          title1.add(enableConsole ? "[gray]" + content.name : "");
        });

        table.row();

        if(content.description != null){
            var any = content.stats.toMap().size > 0;

            if(any){
                table.add("@category.purpose").color(Pal.accent).fillX().padTop(10);
                table.row();
            }

            table.add("[lightgray]" + content.displayDescription()).wrap().fillX().padLeft(any ? 10 : 0).width(500f).padTop(any ? 0 : 10).left();
            table.row();

            if(!content.stats.useCategories && any){
                table.add("@category.general").fillX().color(Pal.accent);
                table.row();
            }
        }

        Stats stats = content.stats;

        for(StatCat cat : stats.toMap().keys()){
            OrderedMap<Stat, Seq<StatValue>> map = stats.toMap().get(cat);

            if(map.size == 0) continue;

            if(stats.useCategories){
                table.add("@category." + cat.name()).color(Pal.accent).fillX();
                table.row();
            }

            for(Stat stat : map.keys()){
                table.table(inset -> {
                    inset.left();
                    inset.add("[lightgray]" + stat.localized() + ":[] ").left().top();
                    Seq<StatValue> arr = map.get(stat);
                    for(StatValue value : arr){
                        value.display(inset);
                        inset.add().size(10f);
                    }

                }).fillX().padLeft(10);
                table.row();
            }
        }

        if(content.details != null){
            table.add("[gray]" + (content.unlocked() || !content.hideDetails ? content.details : Iconc.lock + " " + Core.bundle.get("unlock.incampaign"))).pad(6).padTop(20).width(400f).wrap().fillX();
            table.row();
        }

        ScrollPane pane = new ScrollPane(table);
        cont.add(pane);

        show();
    }
}
