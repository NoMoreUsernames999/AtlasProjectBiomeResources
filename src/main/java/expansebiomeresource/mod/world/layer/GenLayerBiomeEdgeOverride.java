package expansebiomeresource.mod.world.layer;

import biomesoplenty.api.biome.BOPBiomes;
import com.google.common.base.Optional;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import javax.annotation.Nonnull;
import java.util.HashMap;

public class GenLayerBiomeEdgeOverride extends GenLayer {

    private final HashMap<Biome, Biome> biomes;

    public GenLayerBiomeEdgeOverride(long seed, GenLayer parent, HashMap<Biome, Biome> biomes) {
        super(seed);
        this.parent = parent;
        this.biomes = biomes;
    }

    public @Nonnull int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int[] parentVals = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] out = IntCache.getIntCache(areaWidth * areaHeight);
        for(int y = 0; y < areaHeight; ++y) {
            for(int x = 0; x < areaWidth; ++x) {
                this.initChunkSeed(x + areaX, y + areaY);
                int biomeId = parentVals[x + 1 + (y + 1) * (areaWidth + 2)];
                boolean replace = true;
                for(Biome from : biomes.keySet()) {
                    replace = !this.replaceBiomeEdge(parentVals, out, x, y, areaWidth, biomeId, Biome.getIdForBiome(from), Biome.getIdForBiome(biomes.get(from)));
                    if(!replace) break;
                }
                if (replace) out[x + y * areaWidth] = biomeId;
            }
        }

        return out;
    }

    private boolean replaceBiomeEdge(int[] aint, int[] aint1, int areaX, int areaY, int areaWidth, int areaHeight, int biome, int biome1) {
        if (areaHeight != biome) {
            return false;
        } else {
            int k = aint[areaX + 1 + (areaY + 1 - 1) * (areaWidth + 2)];
            int lvt_10_1_ = aint[areaX + 1 + 1 + (areaY + 1) * (areaWidth + 2)];
            int lvt_11_1_ = aint[areaX + 1 - 1 + (areaY + 1) * (areaWidth + 2)];
            int lvt_12_1_ = aint[areaX + 1 + (areaY + 1 + 1) * (areaWidth + 2)];
            if (biomesEqualOrMesaPlateau(k, biome) && biomesEqualOrMesaPlateau(lvt_10_1_, biome) && biomesEqualOrMesaPlateau(lvt_11_1_, biome) && biomesEqualOrMesaPlateau(lvt_12_1_, biome)) {
                aint1[areaX + areaY * areaWidth] = areaHeight;
            } else {
                aint1[areaX + areaY * areaWidth] = biome1;
            }

            return true;
        }
    }

    private boolean canBiomesBeNeighbors(int biome, int biome1) {
        if (biomesEqualOrMesaPlateau(biome, biome1)) {
            return true;
        } else {
            Biome b = Biome.getBiome(biome);
            Biome b1 = Biome.getBiome(biome1);
            if (b != null && b1 != null) {
                Biome.TempCategory aint = b.getTempCategory();
                Biome.TempCategory aint1 = b1.getTempCategory();
                return aint == aint1 || aint == Biome.TempCategory.MEDIUM || aint1 == Biome.TempCategory.MEDIUM;
            } else {
                return false;
            }
        }
    }
}
