package expansebiomeresource.mod.world.layer;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Objects;

public class GenLayerHillsOverride extends GenLayer {

    private static final Logger LOGGER = LogManager.getLogger();
    private final HashMap<Biome, Biome> biomes;
    private final GenLayer riverLayer;

    public GenLayerHillsOverride(long seed, GenLayer parent, GenLayer riverLayer, HashMap<Biome, Biome> biomes) {
        super(seed);
        this.parent = parent;
        this.riverLayer = riverLayer;
        this.biomes = biomes;
    }

    public @Nonnull int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = this.riverLayer.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint2 = IntCache.getIntCache(areaWidth * areaHeight);
        for (int i = 0; i < areaHeight; ++i) {
            for (int j = 0; j < areaWidth; ++j) {
                this.initChunkSeed(j + areaX, i + areaY);
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];
                int l = aint1[j + 1 + (i + 1) * (areaWidth + 2)];
                boolean flag = (l - 2) % 29 == 0;
                if (k > 255) LOGGER.debug("old! {}", k);
                Biome biome = Biome.getBiomeForId(k);
                boolean flag1 = biome != null && biome.isMutation();
                if (k != 0 && l >= 2 && (l - 2) % 29 == 1 && !flag1) {
                    Biome biome3 = Biome.getMutationForBiome(Objects.requireNonNull(biome));
                    aint2[j + i * areaWidth] = biome3 == null ? k : Biome.getIdForBiome(biome3);
                }
                else if (this.nextInt(3) != 0 && !flag) aint2[j + i * areaWidth] = k;
                else {
                    Biome biome1 = biome;
                    if(this.biomes!=null && this.biomes.containsKey(biome) && this.biomes.get(biome)!=null) biome1 = this.biomes.get(biome);
                    int j2 = Biome.getIdForBiome(Objects.requireNonNull(biome1));
                    if (flag && j2 != k) {
                        Biome biome2 = Biome.getMutationForBiome(biome1);
                        j2 = biome2 == null ? k : Biome.getIdForBiome(biome2);
                    }
                    if (j2 == k) aint2[j + i * areaWidth] = k;
                    else {
                        int k2 = aint[j + 1 + (i) * (areaWidth + 2)];
                        int j1 = aint[j + 2 + (i + 1) * (areaWidth + 2)];
                        int k1 = aint[j + (i + 1) * (areaWidth + 2)];
                        int l1 = aint[j + 1 + (i + 2) * (areaWidth + 2)];
                        int i2 = 0;
                        if (biomesEqualOrMesaPlateau(k2, k)) ++i2;
                        if (biomesEqualOrMesaPlateau(j1, k)) ++i2;
                        if (biomesEqualOrMesaPlateau(k1, k)) ++i2;
                        if (biomesEqualOrMesaPlateau(l1, k)) ++i2;
                        if (i2 >= 3) aint2[j + i * areaWidth] = j2;
                        else aint2[j + i * areaWidth] = k;
                    }
                }
            }
        }
        return aint2;
    }
}
