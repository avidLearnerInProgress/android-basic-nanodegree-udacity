package com.example.android.miwok;

/**
 * Created by admin on 27-10-2017.
 */

public class Word {

    private String originalTranslation;
    private String miwokTranslation;
    private static final int NO_IMAGE_VISIBILITY = -1;
    private int imageResoucreId = NO_IMAGE_VISIBILITY;
    private int audioResourceId;


    public Word(String originalTranslation, String miwokTranslation, int audioResourceId) {
        this.originalTranslation = originalTranslation;
        this.miwokTranslation = miwokTranslation;
        this.audioResourceId = audioResourceId;
    }

    public String getOriginalTranslation() {
        return originalTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public int getImageResoucreId() {
        return imageResoucreId;
    }

    public Word(String originalTranslation, String miwokTranslation, int imageResoucreId, int audioResourceId) {
        this.originalTranslation = originalTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResoucreId = imageResoucreId;
        this.audioResourceId = audioResourceId;
    }

    public boolean hasImage() {
        return imageResoucreId != NO_IMAGE_VISIBILITY;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }
}
