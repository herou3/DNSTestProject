package uitests.model;

public interface DisplayAble<T> {

  T shouldBeVisible();

  T shouldNotBeVisible();
}