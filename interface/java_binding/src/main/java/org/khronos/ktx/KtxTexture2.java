/*
 * Copyright (c) 2021, Shukant Pal and Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.khronos.ktx;

public class KtxTexture2 extends KtxTexture {
    protected KtxTexture2(long instance) {
        super(instance);
    }

    public native int getOETF();
    public native boolean getPremultipliedAlpha();
    public native boolean needsTranscoding();
    public native int getVkFormat();
    public native int getSupercompressionScheme();

    public native int compressAstcEx(KtxAstcParams params);
    public native int compressAstc(int quality);
    public native int compressBasisEx(KtxBasisParams params);
    public native int compressBasis(int quality);
    public native int transcodeBasis(int outputFormat, int transcodeFlags);

    /**
     * Create a fresh {@link KTXTexture2}
     *
     * @param createInfo - Paramaters for the texture
     * @param storageAllocation - Pass {@link KTXCreateStorage.ALLOC} if you will write image data.
     */
    public static native KtxTexture2 create(KtxTextureCreateInfo createInfo,
                                            int storageAllocation);

    /**
     * Create a {@link KTXTexture2} from a file.
     *
     * @param filename - The name of the file to read.
     * @param createFlags - Pass {@link KTXTextureCreateFlagBits.LOAD_IMAGE_DATA_BIT} if you
     *                   want to read image data! Otherwise, {@link KTXTexture.getData()} will
     *                    return null.
     */
    public static native KtxTexture2 createFromNamedFile(String filename,
                                                         int createFlags);

    public static KtxTexture2 createFromNamedFile(String filename) {
        return createFromNamedFile(filename, KtxTextureCreateFlagBits.LOAD_IMAGE_DATA_BIT);
    }

    /**
     * Deflate the data in a {@link KtxTexture2} object using Zstandard.
     *
     * The texture's levelIndex, dataSize, DFD, data pointer, and supercompressionScheme will
     * all be updated after successful deflation to reflect the deflated data.
     *
     * @param level Set speed vs compression ratio trade-off. Values
     * between 1 and 22 are accepted. The lower the level the faster. Values
     * above 20 should be used with caution as they require more memory.
     * @return A {@link KtxErrorCode} value
     */
    public native int deflateZstd(int level);

    /**
     * Deflate the data in a {@link KtxTexture2} object using miniz (ZLIB)
     *
     * The texture's levelIndex, dataSize, DFD, data pointer, and supercompressionScheme will
     * all be updated after successful deflation to reflect the deflated data.
     *
     * @param level Set speed vs compression ratio trade-off. Values
     * between 1 and 9 are accepted. The lower the level the faster.
     * @return A {@link KtxErrorCode} value
     */
    public native int deflateZLIB(int level);

}
