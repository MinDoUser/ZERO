package zero.content;


import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.graphics.*;

public class ZBullets implements ContentList{
    public static BulletType circleSmall;
    
    @Override
    public void load(){
            circleSmall = new BasicBulletType(2.88f, 12, "zero-circle"){{
            width =6f;
            height = 11f;
            shrinkY = 0f;
            lifetime = 12f;
            frontColor = Pal.lancerLaser ;
            backColor = Color.white;
            despawnEffect = Fx.none;
            collidesGround = true;
        }};
    }
