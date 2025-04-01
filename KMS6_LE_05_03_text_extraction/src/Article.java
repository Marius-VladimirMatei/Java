// Class designed to hold the information of an article in the format of articleName, articleDescription, orderNumber, value, orderedBy

public class Article {
    private String articleName;
    private String articleDescription;
    private String orderNumber;
    private double value;
    private String orderedBy;

    public Article(String articleName, String articleDescription, String orderNumber, double value, String orderedBy) {
        this.articleName = articleName;
        this.articleDescription = articleDescription;
        this.orderNumber = orderNumber;
        this.value = value;
        this.orderedBy = orderedBy;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(String orderedBy) {
        this.orderedBy = orderedBy;
    }
}
