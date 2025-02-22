package Ex6_6;
public class Test {
    public static void main(String[] args) {
        Animal cat = new Cat("Whiskers");
        Animal dog1 = new Dog("Rex");
        Animal dog2 = new Dog("Buddy");
        Animal bigDog1 = new BigDog("Max");
        Animal bigDog2 = new BigDog("Rocky");
        cat.greets();
        dog1.greets();
        ((Dog) dog1).greets((Dog) dog2);
        bigDog1.greets();
        ((BigDog) bigDog1).greets((Dog) dog1);
        ((BigDog) bigDog1).greets((BigDog) bigDog2);
    }
}
