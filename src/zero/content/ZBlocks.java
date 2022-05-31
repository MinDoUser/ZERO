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

import zero.world.blocks.defense.*;

import static mindustry.type.ItemStack.*;
//import static mindustry.type.LiquidStack.*;

public class ZBlocks implements ContentList{
    public static Block
	    //Wall 
	    arcWall, arcWallBig,
      //Turret
      fragment, hydra,
        //Crafting
        sheetForge, siliconOven;
      @Override
    public void load(){
	int wallHealthMultiplier = 4;

        arcWall = new HealthWall("arc-wall"){{
            requirements(Category.defense, with(Items.surgeAlloy, 12, ZItems.steel, 4, Items.silicon, 4));
            health = 275 * wallHealthMultiplier;
	     healthPercent = 6;
        }};
	arcWallBig = new HealthWall("arc-wall-big"){{
            requirements(Category.defense, with(Items.surgeAlloy, 12*4, ZItems.steel, 4*4, Items.silicon, 4*4));
            health = 275 * 4 * wallHealthMultiplier;
	     healthPercent = 6*2;
		size = 2;
        }};
	    
        sheetForge = new GenericCrafter("sheet-forge") {
			{
				requirements(Category.crafting, with(Items.copper, 260, Items.silicon, 43, Items.graphite, 160));
				craftEffect = Fx.smeltsmoke;
				ItemStack[] out = {new ItemStack(ZItems.steel, 3)};
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
		siliconOven = new GenericCrafter("silicon-oven") {
			{
				requirements(Category.crafting, with(Items.copper, 290, Items.metaglass, 75, Items.graphite, 130));
				craftEffect = Fx.smeltsmoke;
				ItemStack[] out = {new ItemStack(Items.silicon, 1)};
				outputItems = out;
				outputLiquid = new LiquidStack(Liquids.slag, 30);
				craftTime = 54f;
				size = 2;
				hasPower = hasItems = hasLiquids = true;
				drawer = new DrawMixer();//new DrawLiquidRegion(); At 136
				
				ambientSound = Sounds.smelter;
            			ambientSoundVolume = 0.07f;
				
				consumes.items(new ItemStack(Items.sand, 2));
				consumes.power(1.8f);
			}
		};
      fragment = new PowerTurret("fragment"){{
            requirements(Category.turret, with(Items.copper, 120, Items.lead, 25, Items.graphite, 12));
            shootType = new LaserBoltBulletType(2.2f, 13){{
                    lifetime = 26f;
                    //speed = 2.9f;
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
            range = (float)2.2*26;
            shootEffect = Fx.heal;
            heatColor = Color.red;
            recoilAmount = 1f;
            size = 1;
            health = 280;
            shootSound = Sounds.pew;
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
