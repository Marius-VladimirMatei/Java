public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        ArticleService articleService = new ArticleService();
        OutputHandler outputHandler = new OutputHandler();

        while (true) {
            String input = inputHandler.readStringInput(
                    "Please enter the article data in the format:\n" +
                            "\"article name, article description, order number, value, ordered by(name of the person who ordered)\":"
            );

            Article article = articleService.parseArticleFromInput(input);

            if (article != null) {
                outputHandler.printArticleDetails(article);
                outputHandler.printAdditionalInfo(article);
            }

            System.out.println("-----------------------------------\n");
        }
    }
}
