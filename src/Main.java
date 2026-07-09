public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory = BeanFactory.INSTANCE;

        Message message1 = beanFactory.getInstanceOf(Message.class, "Hello"); //type = Message.class args = ["Hello"]
        //same as Message message = new Message("Hello");
        System.out.println("Message 1 = " + message1);

        Message message2 = beanFactory.getInstanceOf(Message.class, "world");
        System.out.println("Message 2 = " + message2);
    }
}