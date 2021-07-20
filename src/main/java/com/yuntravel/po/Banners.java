package com.yuntravel.po;

public class Banners {
    private int imgId;
    private String imgDetail;
    private String imgUrl;
    private String banType;
    private String pathUrl;
    private int useAble;

    public Banners() {
    }

    public Banners(int imgId, String imgDetail, String imgUrl, String banType, String pathUrl, int useAble) {
        this.imgId = imgId;
        this.imgDetail = imgDetail;
        this.imgUrl = imgUrl;
        this.banType = banType;
        this.pathUrl = pathUrl;
        this.useAble = useAble;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgDetail() {
        return imgDetail;
    }

    public void setImgDetail(String imgDetail) {
        this.imgDetail = imgDetail;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBanType() {
        return banType;
    }

    public void setBanType(String banType) {
        this.banType = banType;
    }

    public String getPathUrl() {
        return pathUrl;
    }

    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
    }

    public int getUseAble() {
        return useAble;
    }

    public void setUseAble(int useAble) {
        this.useAble = useAble;
    }

    @Override
    public String toString() {
        return "Banners{" +
                "imgId=" + imgId +
                ", imgDetail='" + imgDetail + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", banType='" + banType + '\'' +
                ", pathUrl='" + pathUrl + '\'' +
                ", useAble=" + useAble +
                '}';
    }
}
