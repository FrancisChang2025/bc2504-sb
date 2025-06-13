import org.springframework.beans.factory.annotation.Autowired;

public class Controller {
  @Autowired(required = false)
  private Animal amimal;
  public void doSomething() {
    if (this.animal != null) {
      this.animal.run();
    }
  }
}
