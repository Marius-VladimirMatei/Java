// Class designed to handle the output of the article information

public class OutputHandler {

    public void printArticleDetails(Article article) {
        System.out.println("\nArticle Details:");
        System.out.println("Full Name:          " + article.getArticleName());
        System.out.println("Description:        " + article.getArticleDescription());
        System.out.println("Order Number:       " + article.getOrderNumber());
        System.out.println("Value:              " + article.getValue());
        System.out.println("Ordered By:         " + article.getOrderedBy());
    }

    // Method to print the article name and order person
    public void printAdditionalInfo(Article article) {
        System.out.println("\nAdditional Info:");
        System.out.println("Article: " + article.getArticleName() + " was ordered by " + article.getOrderedBy());
    }
}
