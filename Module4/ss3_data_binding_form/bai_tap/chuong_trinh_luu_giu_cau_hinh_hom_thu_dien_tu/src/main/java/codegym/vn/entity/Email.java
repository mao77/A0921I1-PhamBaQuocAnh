package codegym.vn.entity;

public class Email {
   private String language;
    private String pageSize;
    private boolean spamFilter;
    private String signature;

    public Email() {
    }

    public Email(String language, String pageSize, boolean spamFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
       this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Email{" +
                "language='" + language + '\'' +
                ", pageSize=" + pageSize +
                ", SpamFilter=" + spamFilter +
                ", signature='" + signature + '\'' +
                '}';
    }
}
