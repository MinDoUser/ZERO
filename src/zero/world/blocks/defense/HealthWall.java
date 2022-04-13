package zero.world.blocks.defense;

import arc.*;
import arc.audio.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;

import mindustry.world.blocks.defense.Wall;
import mindustry.logic.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import mindustry.content.*;


import static mindustry.Vars.*;

public class HealthWall extends Wall{
    public int healthPercent = 10;
    public float healChance = 0.10f;
  public float range = 60f;
      public HealthWall(String name){
        super(name); // Nothing else... Boring constructor
      }
    @Override
    public void setStats(){
        super.setStats();
        // Amount of healing
        //stats.add(Core.bundle.get("stat.zero-healthAmount"), healthPercent, StatUnit.percent); // Booh, unable to make own Stats? Really?
        //stats.add(Core.bundle.get("stat.zero-healChance"), healChance, StatUnit.percent);
        stats.add(Stat.healing, healthPercent, StatUnit.percent);
        //stats.add(, healChance, StatUnit.percent);
        stats.add(Stat.range, range/8, StatUnit.blocks);
    }
      @Override
      public void drawPlace(int x, int y, int rotation, boolean valid){
        super.drawPlace(x, y, rotation, valid);
        
        Drawf.dashCircle(x * tilesize + offset, y * tilesize + offset, range, Pal.heal);

        indexer.eachBlock(player.team(), x * tilesize + offset, y * tilesize + offset, range, other -> true, other -> Drawf.selected(other, Tmp.c1.set(Pal.heal).a(Mathf.absin(4f, 1f))));
      }
  
      public class HealthWallBuild extends WallBuild implements Ranged{
        float healAmount;
        @Override
        public float range(){
          if(range < 0) range = 100;
          return range;
        }
        @Override
        public boolean collision(Bullet bullet){
            boolean b = super.collision(bullet);
            if(Mathf.chance(healChance)){
            heal(bullet);
            }
            return b;
      }
          /**
          @param bullet The bullet used to get eg. damage of it.
          */
      public void heal(Bullet bullet){
          indexer.allBuildings(this.x, this.y, range(), other -> {
              healAmount = (other.maxHealth/100)*healthPercent;
              if(other.team == this.team){
                other.heal(healAmount);
                Fx.healBlockFull.at(other.x, other.y, other.block.size, Pal.heal);
              }
            });
      }
      @Override
      public void drawSelect(){
       indexer.eachBlock(this, range(), other -> true, other -> Drawf.selected(other, Tmp.c1.set(Pal.heal).a(Mathf.absin(4f, 1f))));

            Drawf.dashCircle(x, y, range(), Pal.heal);
      }
}
}
