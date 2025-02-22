package Ex6_7;
public class TestAnimal {
        public TestAnimal() {
        }

        public static void main(String[] args) {
            Cat cat = new Cat();
            cat.greeting();
            Dog dog = new Dog();
            dog.greeting();
            BigDog bigDog1 = new BigDog();
            bigDog1.greeting();
            BigDog bigDog2 = new BigDog();
            bigDog1.greeting(bigDog2);
            Animal animal1 = new Cat();
            animal1.greeting();
            Animal animal2 = new Dog();
            animal2.greeting();
            Animal animal3 = new BigDog();
            animal3.greeting();
            Dog dog2 = (Dog)animal2;
            dog2.greeting();
            BigDog bigDog3 = (BigDog)animal3;
            bigDog3.greeting();
            dog2.greeting(bigDog3);
            bigDog3.greeting(dog2);
        }
}
