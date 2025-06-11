public class ShoppingMall {
  private String name;
  private Integer area;
  private Cinema cinema;
  private List<String> shopCategory;

  public static class Cinema {
    private String name;
    private String openedDate;
    private List<ReleasedFilm> releasedFilms;

    public static class ReleasedFilm {
      private String name;
      private String releaseDate;
    }
  }
}
