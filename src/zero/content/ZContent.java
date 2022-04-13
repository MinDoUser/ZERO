package zero.content;

import arc.Core;
import arc.func.Cons;
import arc.graphics.Texture;
import arc.graphics.g2d.TextureRegion;
import mindustry.ctype.*;
import zero.ZeroMod;

public class ZContent implements ContentList{
  //UI for dialogs.
  	public static TextureRegion logo;
  @Override
  public void load(){
    logo = Core.atlas.find(ZeroMod.getName("logo"));
  }
}
