package net.trashelemental.floral_tonics_and_tinctures.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WayfarerParticles extends TextureSheetParticle {

    private static final int LIFETIME_TICKS = 36_000; // 30 minutes

    protected WayfarerParticles(ClientLevel world, double x, double y, double z,
                                double xd, double yd, double zd) {
        super(world, x, y, z, xd, yd, zd);

        this.lifetime = LIFETIME_TICKS;
        this.gravity = 0.01f;
        this.quadSize *= 1.2f;

        this.xd = 0;
        this.yd = 0;
        this.zd = 0;

        this.setAlpha(1.0f);
    }

    @Override
    public int getLightColor(float partialTick) {
        return 0xF000F0;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.age++ >= this.lifetime) {
            this.remove();
            return;
        }

        float progress = (float) this.age / this.lifetime;

        float colorPhase = Math.min(progress / 0.75f, 1.0f);
        float startRed = 1.0f;
        float startGreen = 1.0f;
        float startBlue = 1.0f;
        float endRed = 1.0f;
        float endGreen = 0.5f;
        float endBlue = 0.5f;
        float currentRed = startRed + (endRed - startRed) * colorPhase;
        float currentGreen = startGreen + (endGreen - startGreen) * colorPhase;
        float currentBlue = startBlue + (endBlue - startBlue) * colorPhase;
        this.setColor(currentRed, currentGreen, currentBlue);

        if (progress < 0.75f) {
            this.setAlpha(1.0f);
        } else {
            float fadeProgress = (progress - 0.75f) / 0.25f;
            this.setAlpha(1.0f - fadeProgress);
        }

        if (this.yd > 0) this.yd *= 0.5;
        this.yd -= this.gravity;

        if (this.onGround) {
            this.yd = 0;
            this.xd = 0;
            this.zd = 0;
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel world,
                                       double x, double y, double z,
                                       double xd, double yd, double zd) {
            WayfarerParticles particle = new WayfarerParticles(world, x, y, z, xd, yd, zd);
            particle.pickSprite(spriteSet);
            return particle;
        }
    }
}