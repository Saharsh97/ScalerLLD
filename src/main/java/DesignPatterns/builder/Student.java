package main.java.DesignPatterns.builder;

public class Student {
    int id;
    String name;
    double psp;
    int age;
    String univName;
    int gradYear;

    private Student(Builder builder){
        this.id = builder.getId();
        this.name = builder.getName();
        this.univName = builder.getUnivName();
        this.age = builder.getAge();
        this.gradYear = builder.getGradYear();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    static class Builder {
        int id;
        String name;
        double psp;
        int age;
        String univName;
        int gradYear;

        public int getId() {
            return id;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getUnivName() {
            return univName;
        }

        public Builder setUnivName(String univName) {
            this.univName = univName;
            return this;
        }

        public int getGradYear() {
            return gradYear;
        }

        public Builder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        //so now the build func builds student object by passing all the setted attributes
        public Student build() {
            if (age < 22) {
                throw new IllegalArgumentException("Age cannot be less than 22");
            }
            if (name == null) {
                throw new IllegalArgumentException("Name cannot be empty, please give a name");
            }
            return new Student(this);
        }
    }
}
