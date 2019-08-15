package com.bsworld.springboot.generic;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-07-29 15:37
 * description:
 */
public enum  NovelPaidType {
    /**
     *
     * 小说章节付费
     * */
    CHAPTER(1),
    /**
     * 小说商品付费
     */
    GOODS(2);

    private int index;

    public int getIndex() {
        return index;
    }

    NovelPaidType(int index) {
        this.index = index;
    }

    public static NovelPaidType get(int index) {
        for (NovelPaidType status : NovelPaidType.values()) {
            if (status.getIndex() == index) {
                return status;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        NovelPaidType novelPaidType = NovelPaidType.get(2);
        System.out.println(novelPaidType);
    }
}
