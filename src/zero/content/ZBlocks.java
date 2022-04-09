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
      fragment, hydra,
        //Crafting
        sheetForge;
      @Override
    public void load(){
        sheetForge = new GenericCrafter("sheet-forge") {
			{
				requirements(Category.crafting, with(Items.copper, 260, Items.silicon, 43, Items.graphite, 160));
				craftEffect = Fx.smeltsmoke;
				ItemStack[] out = {new ItemStack(ZItems.steel, 3), new ItemStack(Items.silicon, 1)};
				outputItems = out;
				craftTime = 56f;
				size = 2;
				hasPower = hasItems = true;
				drawer = new DrawSmelter();
				
				ambientSound = Sounds.smelter;
            			ambientSoundVolume = 0.07f;
				
				consumes.items(new ItemStack(Items.graphite,3), new ItemStack(Items.copper,4), new ItemStack(Items.lead,3));
				consumes.power(1.8f);
			}
		};
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
        hydra = new PowerTurret("hydra"){{
            requirements(Category.turret, with(Items.copper, 220, Items.lead, 310, Items.graphite, 120, Items.silicon, 80));
            shootType = ZBullets.circleSmall;
            reloadTime = 26f;
            shootCone = 44f;
            rotateSpeed = 2.7f;
            powerUse = 4.11f;
            targetAir = false;
            targetHealing = false;
            range = ZBullets.circleSmall.lifetime * ZBullets.circleSmall.speed;
            shootEffect = Fx.absorb;
            heatColor = Color.red;
            recoilAmount = 1.1f;
            size = 2;
            health = 780;
            shootSound = Sounds.laser;
        }};
    }
}
