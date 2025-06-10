import java.time.LocalDate;
import java.util.List;

public class ShoppingMall {
  private String name;
  private Integer area;
  private Cinema cinema;
  private List<String> shopCategory;

  public static class Cinema {
    private String name;
    private LocalDate openDate;
    private List<ReleasedFilm> releasedFilms;

   public static class ReleasedFilm {
     private String name;
     private LocalDate releasDate;
   }
  }
}
