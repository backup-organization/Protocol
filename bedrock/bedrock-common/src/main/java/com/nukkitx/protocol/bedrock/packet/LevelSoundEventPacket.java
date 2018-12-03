package com.nukkitx.protocol.bedrock.packet;

import com.flowpowered.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.handler.BedrockPacketHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LevelSoundEventPacket extends BedrockPacket {
    protected Sound sound;
    protected Vector3f position;
    protected int extraData;
    protected int pitch;
    protected boolean unknown0;
    protected boolean relativeVolumeDisabled;

    @Override
    public final boolean handle(BedrockPacketHandler handler) {
        return handler.handle(this);
    }

    public enum Sound {
        ITEM_USE_ON,
        HIT,
        STEP,
        FLY,
        JUMP,
        BREAK,
        PLACE,
        HEAVY_STEP,
        GALLOP,
        FALL,
        AMBIENT,
        AMBIENT_BABY,
        AMBIENT_IN_WATER,
        BREATHE,
        DEATH,
        DEATH_IN_WATER,
        DEATH_TO_ZOMBIE,
        HURT,
        HURT_IN_WATER,
        MAD,
        BOOST,
        BOW,
        SQUISH_BIG,
        SQUISH_SMALL,
        FALL_BIG,
        FALL_SMALL,
        SPLASH,
        FIZZ,
        FLAP,
        SWIM,
        DRINK,
        EAT,
        TAKEOFF,
        SHAKE,
        PLOP,
        LAND,
        SADDLE,
        ARMOR,
        MOB_ARMOR_STAND_PLACE,
        ADD_CHEST,
        THROW,
        ATTACK,
        ATTACK_NODAMAGE,
        ATTACK_STRONG,
        WARN,
        SHEAR,
        MILK,
        THUNDER,
        EXPLODE,
        FIRE,
        IGNITE,
        FUSE,
        STARE,
        SPAWN,
        SHOOT,
        BREAK_BLOCK,
        LAUNCH,
        BLAST,
        LARGE_BLAST,
        TWINKLE,
        REMEDY,
        UNFECT,
        LEVELUP,
        BOW_HIT,
        BULLET_HIT,
        EXTINGUISH_FIRE,
        ITEM_FIZZ,
        CHEST_OPEN,
        CHEST_CLOSED,
        SHULKERBOX_OPEN,
        SHULKERBOX_CLOSED,
        ENDERCHEST_OPEN,
        ENDERCHEST_CLOSED,
        POWER_ON,
        POWER_OFF,
        ATTACH,
        DETACH,
        DENY,
        TRIPOD,
        POP,
        DROP_SLOT,
        NOTE,
        THORNS,
        PISTON_IN,
        PISTON_OUT,
        PORTAL,
        WATER,
        LAVA_POP,
        LAVA,
        BURP,
        BUCKET_FILL_WATER,
        BUCKET_FILL_LAVA,
        BUCKET_EMPTY_WATER,
        BUCKET_EMPTY_LAVA,
        ARMOR_EQUIP_CHAIN,
        ARMOR_EQUIP_DIAMOND,
        ARMOR_EQUIP_GENERIC,
        ARMOR_EQUIP_GOLD,
        ARMOR_EQUIP_IRON,
        ARMOR_EQUIP_LEATHER,
        ARMOR_EQUIP_ELYTRA,
        RECORD_13,
        RECORD_CAT,
        RECORD_BLOCKS,
        RECORD_CHIRP,
        RECORD_FAR,
        RECORD_MALL,
        RECORD_MELLOHI,
        RECORD_STAL,
        RECORD_STRAD,
        RECORD_WARD,
        RECORD_11,
        RECORD_WAIT,
        STOP_RECORD, //Not really a sound
        FLOP,
        ELDERGUARDIAN_CURSE,
        MOB_WARNING,
        MOB_WARNING_BABY,
        TELEPORT,
        SHULKER_OPEN,
        SHULKER_CLOSE,
        HAGGLE,
        HAGGLE_YES,
        HAGGLE_NO,
        HAGGLE_IDLE,
        CHORUSGROW,
        CHORUSDEATH,
        GLASS,
        POTION_BREWED,
        CAST_SPELL,
        PREPARE_ATTACK,
        PREPARE_SUMMON,
        PREPARE_WOLOLO,
        FANG,
        CHARGE,
        CAMERA_TAKE_PICTURE,
        LEASHKNOT_PLACE,
        LEASHKNOT_BREAK,
        GROWL,
        WHINE,
        PANT,
        PURR,
        PURREOW,
        DEATH_MIN_VOLUME,
        DEATH_MID_VOLUME,
        IMITATE_BLAZE,
        IMITATE_CAVE_SPIDER,
        IMITATE_CREEPER,
        IMITATE_ELDER_GUARDIAN,
        IMITATE_ENDER_DRAGON,
        IMITATE_ENDERMAN,
        IMITATE_EVOCATION_ILLAGER,
        IMITATE_GHAST,
        IMITATE_HUSK,
        IMITATE_ILLUSION_ILLAGER,
        IMITATE_MAGMA_CUBE,
        IMITATE_POLAR_BEAR,
        IMITATE_SHULKER,
        IMITATE_SILVERFISH,
        IMITATE_SKELETON,
        IMITATE_SLIME,
        IMITATE_SPIDER,
        IMITATE_STRAY,
        IMITATE_VEX,
        IMITATE_VINDICATION_ILLAGER,
        IMITATE_WITCH,
        IMITATE_WITHER,
        IMITATE_WITHER_SKELETON,
        IMITATE_WOLF,
        IMITATE_ZOMBIE,
        IMITATE_ZOMBIE_PIGMAN,
        IMITATE_ZOMBIE_VILLAGER,
        BLOCK_END_PORTAL_FRAME_FILL,
        BLOCK_END_PORTAL_SPAWN,
        RANDOM_ANVIL_USE,
        BOTTLE_DRAGONBREATH,
        PORTAL_TRAVEL,
        ITEM_TRIDENT_HIT,
        ITEM_TRIDENT_RETURN,
        ITEM_TRIDENT_RIPTIDE_1,
        ITEM_TRIDENT_RIPTIDE_2,
        ITEM_TRIDENT_RIPTIDE_3,
        ITEM_TRIDENT_THROW,
        ITEM_TRIDENT_THUNDER,
        ITEM_TRIDENT_HIT_GROUND,
        DEFAULT,
        ELEMCONSTRUCT_OPEN,
        ICEBOMB_HIT,
        BALLOONPOP,
        LT_REACTION_ICEBOMB,
        LT_REACTION_BLEACH,
        LT_REACTION_EPASTE,
        LT_REACTION_EPASTE2,
        LT_REACTION_FERTILIZER,
        LT_REACTION_FIREBALL,
        LT_REACTION_MGSALT,
        LT_REACTION_MISCFIRE,
        LT_REACTION_FIRE,
        LT_REACTION_MISCEXPLOSION,
        LT_REACTION_MISCMYSTICAL,
        LT_REACTION_MISCMYSTICAL2,
        LT_REACTION_PRODUCT,
        SPARKLER_USE,
        GLOWSTICK_USE,
        SPARKLER_ACTIVE,
        CONVERT_TO_DROWNED,
        BUCKET_FILL_FISH,
        BUCKET_EMPTY_FISH,
        UNDEFINED,
    }
}