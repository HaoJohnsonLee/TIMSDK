package com.zs.tim.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class TIMGetHistoryResponse extends TIMResponse {
    @JSONField(name = "File")
    private List<FileBean> file;


    public List<FileBean> getFile() {
        return file;
    }

    public void setFile(List<FileBean> file) {
        this.file = file;
    }

    public static class FileBean {
        /**
         * url : https://download.tim.qq.com/msg_history/2/9b8f8f063b73f61698ce11e58207e89ade40.gz
         * expireTime : 2015-12-02 16:45:23
         * fileSize : 65207
         * fileMD5 : cceece008bb7f469a47cf8c4b7acb84e
         * GzipSize : 1815
         * GzipMD5 : c3a0269dde393fd7a8bb18bfdeaeee2e
         */
        @JSONField(name = "URL")
        private String url;
        @JSONField(name = "ExpireTime")
        private String expireTime;
        @JSONField(name = "FileSize")
        private int fileSize;
        @JSONField(name="FileMD5")
        private String fileMD5;
        @JSONField(name = "GzipSize")
        private int GzipSize;
        @JSONField(name = "GzipMD5")
        private String GzipMD5;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(String expireTime) {
            this.expireTime = expireTime;
        }

        public int getFileSize() {
            return fileSize;
        }

        public void setFileSize(int fileSize) {
            this.fileSize = fileSize;
        }

        public String getFileMD5() {
            return fileMD5;
        }

        public void setFileMD5(String fileMD5) {
            this.fileMD5 = fileMD5;
        }

        public int getGzipSize() {
            return GzipSize;
        }

        public void setGzipSize(int GzipSize) {
            this.GzipSize = GzipSize;
        }

        public String getGzipMD5() {
            return GzipMD5;
        }

        public void setGzipMD5(String GzipMD5) {
            this.GzipMD5 = GzipMD5;
        }
    }
}
