package zero.entities.bullets;

import mindustry.entities.bullet.*;
import mindustry.content.*;

public class MultiEffectBulletType extends BasicBulletType{
    public int despawnEffects = 1; // 1 by default, to avoid NullPointer
      public MultiEffectBulletType(float speed, float damage, String bulletSprite){
        super(speed, damage, bulletSprite);
    }
      public MultiEffectBulletType(float speed, float damage){
        this(speed, damage, "bullet");
    }
  @Override
      public void despawned(Bullet b){
        if(super.despawnHit){
            super.hit(b);
        }
        for(int i=0; i<despawnEffects; i++){
        super.despawnEffect.at(b.x, b.y, b.rotation(), hitColor);
        }
        despawnSound.at(b);

        Effect.shake(despawnShake, despawnShake, b);
    }
}
