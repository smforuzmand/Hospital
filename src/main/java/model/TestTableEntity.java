package model;

public class TestTAbleEntity {


      private int id;
      private String description;
      private int number;

      public TestTAbleEntity(String description, int number) {
            this.description = description;
            this.number = number;
      }

      public TestTAbleEntity(int id, String description, int number) {
            this.id = id;
            this.description = description;
            this.number = number;
      }

      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public String getDescription() {
            return description;
      }

      public void setDescription(String description) {
            this.description = description;
      }

      public int getNumber() {
            return number;
      }

      public void setNumber(int number) {
            this.number = number;
      }

      @Override
      public String toString() {
            return "TestTAbleEntity{" +
                    "id=" + id +
                    ", description='" + description + '\'' +
                    ", number=" + number +
                    '}';
      }
}
