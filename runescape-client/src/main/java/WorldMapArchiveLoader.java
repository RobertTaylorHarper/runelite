import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ok")
@Implements("WorldMapArchiveLoader")
public class WorldMapArchiveLoader {
	@ObfuscatedName("l")
	@Export("cacheName")
	String cacheName;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	@Export("archive")
	AbstractArchive archive;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1032853053
	)
	@Export("percentLoaded")
	int percentLoaded;
	@ObfuscatedName("f")
	@Export("loaded")
	boolean loaded;

	@ObfuscatedSignature(
		descriptor = "(Llq;)V"
	)
	WorldMapArchiveLoader(AbstractArchive var1) {
		this.percentLoaded = 0; // L: 13
		this.loaded = false; // L: 14
		this.archive = var1; // L: 17
	} // L: 18

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "31"
	)
	@Export("reset")
	void reset(String var1) {
		if (var1 != null && !var1.isEmpty()) { // L: 21
			if (var1 != this.cacheName) { // L: 24
				this.cacheName = var1; // L: 27
				this.percentLoaded = 0; // L: 28
				this.loaded = false; // L: 29
				this.load(); // L: 30
			}
		}
	} // L: 22 25 31

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1161037724"
	)
	@Export("load")
	int load() {
		if (this.percentLoaded < 33) { // L: 34
			if (!this.archive.tryLoadFileByNames(WorldMapCacheName.field2847.name, this.cacheName)) { // L: 35
				return this.percentLoaded; // L: 36
			}

			this.percentLoaded = 33; // L: 38
		}

		if (this.percentLoaded == 33) { // L: 40
			if (this.archive.isValidFileName(WorldMapCacheName.field2846.name, this.cacheName) && !this.archive.tryLoadFileByNames(WorldMapCacheName.field2846.name, this.cacheName)) { // L: 41 42
				return this.percentLoaded; // L: 43
			}

			this.percentLoaded = 66; // L: 46
		}

		if (this.percentLoaded == 66) { // L: 48
			if (!this.archive.tryLoadFileByNames(this.cacheName, WorldMapCacheName.field2850.name)) { // L: 49
				return this.percentLoaded; // L: 50
			}

			this.percentLoaded = 100; // L: 52
			this.loaded = true; // L: 53
		}

		return this.percentLoaded; // L: 55
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2001859589"
	)
	@Export("isLoaded")
	boolean isLoaded() {
		return this.loaded; // L: 59
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-788311036"
	)
	@Export("getPercentLoaded")
	int getPercentLoaded() {
		return this.percentLoaded; // L: 63
	}
}
