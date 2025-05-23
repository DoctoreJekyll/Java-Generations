import java.util.List;
import java.util.Objects;

public class VendingMachine {

    private List<Article> articles;
    private double balance;

    public VendingMachine(List<Article> articles, double balance) {
        this.articles = articles;
        this.balance = balance;
    }

    public void vend(String code, double amount){
        String codeUpperCaseInsert = code.toUpperCase();

        for (Article article : articles)
        {
            if(Objects.equals(article.getCode(), codeUpperCaseInsert) && article.getPrice() <= amount)
            {
                buyThisArticle(article, codeUpperCaseInsert);
            }
            else
            {
                System.out.println("No se puede vender este articulo");
            }
        }
    }

    private void buyThisArticle(Article article, String code){
        for (Article article1 : articles){
            if(Objects.equals(article1.getCode(), code)){
                if (article1.getStock() > 0){
                    article1.setStock(article1.getStock() - 1);
                    balance += article.getPrice();
                    System.out.println(article1.getName() + " se ha vendido y quedan: " + article1.getStock());
                }
                else
                {
                    System.out.println("No hay stock de este articulo");
                }
            }
        }
    }


}
