package cn.qy.store.controller.ex;

/**
 * @description: 文件上传相关的基类
 * @author: QiuYang
 * @time: 2022/7/18
 */
public class FileUploadException extends RuntimeException{
    public FileUploadException() {
        super();
    }

    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadException(Throwable cause) {
        super(cause);
    }

    protected FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
