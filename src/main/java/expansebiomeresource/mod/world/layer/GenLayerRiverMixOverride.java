package expansebiomeresource.mod.world.layer;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import javax.annotation.Nonnull;
import java.util.List;

public class GenLayerRiverMixOverride extends GenLayer {

    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;
    private final List<Biome> oceans;
    private final List<Biome> rivers;

    public GenLayerRiverMixOverride(long seed, GenLayer biomePatternGeneratorChain, GenLayer riverPatternGeneratorChain, List<Biome> oceans, List<Biome> rivers) {
        super(seed);
        this.biomePatternGeneratorChain = biomePatternGeneratorChain;
        this.riverPatternGeneratorChain = riverPatternGeneratorChain;
        this.oceans = oceans;
        this.rivers = rivers;
    }

    public void initWorldGenSeed(long seed) {
        this.biomePatternGeneratorChain.initWorldGenSeed(seed);
        this.riverPatternGeneratorChain.initWorldGenSeed(seed);
        super.initWorldGenSeed(seed);
    }

    @Override
    public @Nonnull int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int[] biomeInts = this.biomePatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] riverInts = this.riverPatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint = IntCache.getIntCache(areaWidth * areaHeight);

        for(int i = 0; i < areaWidth * areaHeight; ++i) {
            Biome biomeInt = Biome.getBiome(biomeInts[i]);
            Biome riverInt = Biome.getBiome(riverInts[i]);
            if (!this.oceans.contains(biomeInt)) {
                if (this.rivers.contains(riverInt)) aint[i] = riverInts[i] & 255;
                else aint[i] = biomeInts[i];
            } else aint[i] = biomeInts[i];
        }
        return aint;
    }
}
