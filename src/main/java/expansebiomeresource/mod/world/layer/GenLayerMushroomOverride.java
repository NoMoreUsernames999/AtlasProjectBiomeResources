package expansebiomeresource.mod.world.layer;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import javax.annotation.Nonnull;

public class GenLayerMushroomOverride extends GenLayer {
    private final Biome mushroom;

    public GenLayerMushroomOverride(long seed, GenLayer parent, Biome mushroom) {
        super(seed);
        this.parent = parent;
        this.mushroom = mushroom;
    }

    @Override
    public @Nonnull int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int i = areaX - 1;
        int j = areaY - 1;
        int k = areaWidth + 2;
        int l = areaHeight + 2;
        int[] aint = this.parent.getInts(i, j, k, l);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for(int i1 = 0; i1 < areaHeight; ++i1) {
            for(int j1 = 0; j1 < areaWidth; ++j1) {
                int k1 = aint[j1 + (i1) * k];
                int l1 = aint[j1 + 2 + (i1) * k];
                int i2 = aint[j1 + (i1 + 2) * k];
                int j2 = aint[j1 + 2 + (i1 + 2) * k];
                int k2 = aint[j1 + 1 + (i1 + 1) * k];
                this.initChunkSeed(j1 + areaX, i1 + areaY);
                if (k2 == 0 && k1 == 0 && l1 == 0 && i2 == 0 && j2 == 0 && this.nextInt(100) == 0) {
                    aint1[j1 + i1 * areaWidth] = Biome.getIdForBiome(this.mushroom);
                } else {
                    aint1[j1 + i1 * areaWidth] = k2;
                }
            }
        }

        return aint1;
    }
}
