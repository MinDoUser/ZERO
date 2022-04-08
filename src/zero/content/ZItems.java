package zero.content;

import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.type.*;

public class Items implements ContentList{
    public static Item
    steel;
      @Override
    public void load(){
        steel = new Item("steel", Color.valueOf("97a0af")){{
            hardness = 1.3;
            cost = 0.9f;
            alwaysUnlocked = false;
        }};
    }
}
