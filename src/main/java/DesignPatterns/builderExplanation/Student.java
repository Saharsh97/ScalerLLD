package main.java.DesignPatterns.builderExplanation;

public class Student {
    int id;
    String name;
    double psp;
    int age;
    String univName;
    int gradYear;

//1.    Student(int id, String univName, String name, double psp);

    private Student(Builder builder){
        this.id = builder.getId();
        this.name = builder.getName();
        this.psp = builder.getPsp();
        this.age = builder.getAge();
        this.univName = builder.getUnivName();
        this.gradYear = builder.getGradYear();
    }

    // 2.
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

        // 3.
        public Student build(){
            if(age < 22){
                throw new IllegalArgumentException("Age cannot be less than 22");
            }
            if(name == null){
                throw new IllegalArgumentException("Name cannot be empty, please give a name");
            }

            // once everything is clear, make the Student Object.
            return new Student(this);
        }
    }
}
