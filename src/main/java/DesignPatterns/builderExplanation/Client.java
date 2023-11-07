package main.java.DesignPatterns.builderExplanation;

// 8:15
// code can get confusing. Explain in depth.
public class Client {
    public static void main(String[] args) {

//        Student st = new Student(1, "Saharsh", "some college", 90.0); // error
//        Builder builder = new Builder();
//        builder.setAge(26);
//        builder.setName("Saharsh");
//        builder.setGradYear(2019);
//
//        Student st = new Student(builder);

//        2.
        // a) but is this intuitive to the client?
        // client tries to make object of Student, on going inside, he sees Builder argument.
        // so he studies Builder, make a builder object, and give it to student.

        // b) how does the client know that a builder has to be there, before a student is made?
        // it should be the sole responsibility of student to make its object.
        // student should provide the builder!

        // c) if I just look at line 6, can I say I am doing anything for student?
        // how does line 6 say that, the builder is meant for the student only and no one else!
        // I will ask Student, please create the builder

        // add: public getBuilder() return new Student(this).
        // show flow using debugger.

        // d) but this also has a problem?? Im first making a student object, then calling builder.
        // I should be able to call builder before the Student object is made.
        // make it static.


        // 8:25
//        Builder builder2 = Student.getBuilder();
//        builder2.setAge(26);
//        builder2.setName("Saharsh");
//        builder2.setGradYear(2019);
//
//        Student st2 = new Student(builder2);

        // 8:30
//        3. I have a Builder, but is it actually building anything? It is just acting like a data structure!
        // making Builder responsible for what its name suggests! It has to build something!
        // now Builder is responsible for validating the data, and keeping the Student class very simple, with no Responsibility.
        // Builder does the heavy work.
        // add build() in Builder.

//        Builder builder3 = Student.getBuilder();
//        builder3.setAge(26);
//        builder3.setName("Saharsh");
//        builder3.setGradYear(2019);
//
//        Student st3 = builder3.build();
        // this is now a complete circle.
        // explain above.

        // Sequence:
//        o getBuilder will create object of the Builder class
//        o Pass the Values to Builder Object
//        o Data will get Validated in the Builder Class
//        o Student object will get created in Builder Class



        // 8:40
//        4. Does the above look better, or the below one looks better
        // which one is more readable?
        Student builder4 = Student.getBuilder()
                                    .setAge(26)
                                    .setName("Saharsh")
                                    .setGradYear(2019)
                                    .build();
        // This looks like plain english! and now the Client doesnt even need to make a Builder object separately
        // fix the code.
        // Previously, until I open the Student, look at Builder, then I get to know what needs to be done.
        // but in this case, Client can make Student in one go, like plain english!

        // 8:50
//        5. Does anyone still stop you from doing this: Student st = new Student(builder) ??
        // why should there be 2 ways of creating the same thing.
        // I would want everyone to use a builder, then this way of object creation should be exposed.
        // no one should be able to create objects like this.

        // how can I stop anyone from this? I should make the constructor private.
        // => make Student constructor private.

        // but an issue has occurred now? Builder is a separate class, how can it access the Student constructor.
        // now who can access private members?? the class itself.
        // => so the builder can be moved inside the Student class.
        // this also makes it more clear, that Student has a dedicated Builder!

        // now another problem, static getBuilder(), so the Builder class should also be static.
        // this is the final Version!
        System.out.println("works fine!");

    }
}
