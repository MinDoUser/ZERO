package zero.content;


import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.graphics.*;
import mindustry.content.*;

import zero.entities.bullets.*;

public class ZBullets implements ContentList{
    public static BulletType circleSmall;
    
    @Override
    public void load(){
            circleSmall = new MultiEffectBulletType(2.88f, 12, "zero-circle"){{
                despawnEffects  = 12;
            width =15f;
            height = 15f;
            shrinkY = 0f;
            lifetime = 67f;
            frontColor = Pal.lancerLaser ;
            backColor = Color.white;
            despawnEffect = Fx.smeltsmoke;
            collidesGround = true;
        }};
    }
}
