package zero.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.ctype.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import mindustry.content.*;

import static mindustry.type.ItemStack.*;

public class ZBlocks implements ContentList{
    public static Block
      //Turret
      fragment;
      @Override
    public void load(){
      fragment = new PowerTurret("fragment"){{
            requirements(Category.turret, with(Items.copper, 120, Items.lead, 25, Items.graphite, 12));
            shootType = new LaserBoltBulletType(5.2f, 13){{
                    lifetime = 24f;
                    speed = 2.9f;
                    healPercent = 7f;
                    collidesTeam = true;
                    backColor = Pal.heal;
                    frontColor = Color.white;
                }};
            reloadTime = 32f;
            shootCone = 40f;
            rotateSpeed = 8f;
            powerUse = 3.77f;
            targetAir = false;
            targetHealing = true;
            range = 120f;
            shootEffect = Fx.heal;
            heatColor = Color.red;
            recoilAmount = 1f;
            size = 1;
            health = 280;
            shootSound = Sounds.none;
        }};
    }
}
