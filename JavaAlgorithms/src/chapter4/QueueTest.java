package chapter4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    Queue<Integer> sut ;

    @BeforeEach
    public void setUp(){
        sut = new Queue<>(3);
    }

    @Test
    public void shouldInsertNewElements(){
        assertTrue(sut.isEmpty());

        sut.insert(1);

        assertFalse(sut.isEmpty());

        assertEquals(1, sut.peek());

    }

    @Test
    public void shouldRemoveAndReturnTheFirstElementInserted(){
        sut.insert(1);
        sut.insert(2);

        assertEquals(1,sut.remove());
        assertEquals(2, sut.remove());
        assertTrue(sut.isEmpty());

    }

    @Test
    public void shouldThrowIAEWhenInsertingIntoFullQueue(){
        sut.insert(1);
        sut.insert(2);
        sut.insert(3);

        System.out.println(assertThrows(IllegalArgumentException.class, () -> sut.insert(4)).getMessage());

        sut.remove();

        assertDoesNotThrow(() -> sut.insert(4));
    }

    @Test
    public void shouldThrowIAEWhenAskingForElementInEmptyQueue(){
        sut.insert(1);
        sut.insert(2);
        sut.insert(3);

        sut.remove();
        sut.remove();
        sut.remove();

        assertThrows(IllegalArgumentException.class, () -> sut.remove());

        sut.insert(4);

        assertEquals(4, sut.remove());
    }

    @Test
    public void testOfDisplay() {
        sut = new Queue<>(10);
        sut.insert(1);
        sut.insert(2);
        sut.insert(3);
        sut.insert(4);
        sut.insert(5);
        sut.insert(6);
        sut.insert(7);
        sut.insert(8);
        sut.insert(9);
        sut.insert(10);

        sut.remove();

        sut.remove();

        sut.insert(11);
        sut.insert(12);

        sut.display();
    }

    @Test
    public void marketExample() throws InterruptedException {

        Queue<String> queue1 = new Queue<>(400);

        Queue<String> queue2 = new Queue<>(400);

        Queue<String> queue3 = new Queue<>(400);


        Thread queueOne = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                if (!queue1.isEmpty()) {
                    try {
                        Thread.sleep((long) (Math.random()*200));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("Queue1 info: ");
                    queue1.display();
                    System.out.println("\n");

                    String client = queue1.remove();

                    System.out.println("Queue1:" + client + " done.");

                }
            }
        });

        Thread queueTwo = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                if (!queue2.isEmpty()) {
                    try {
                        Thread.sleep((long) (Math.random()*200));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("Queue2 info: ");
                    queue2.display();
                    System.out.println("\n");

                    String client = queue2.remove();

                    System.out.println("Queue2:" + client + " done.");

                }
            }
        });

        Thread queueThree = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                if (!queue3.isEmpty()) {
                    try {
                        Thread.sleep((long) (Math.random()*200));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("Queue3 info: ");
                    queue3.display();
                    System.out.println("\n");

                    String client = queue3.remove();

                    System.out.println("Queue3:" + client + " done.");

                }
            }
        });

        queueOne.start();
        queueTwo.start();
        queueThree.start();

        int numOfCustomers = (int) (Math.random() * 400);

        for (int i = 0; i < numOfCustomers; i++) {
            int size1 = queue1.getNumOfItems();
            int size2 = queue2.getNumOfItems();
            int size3 = queue3.getNumOfItems();
            if (size1 <= size2 && size1 <= size3) {
                queue1.insert("Client"+i);
            } else if (size2 <= size1 && size2 <= size3) {
                queue2.insert("Client"+i);
            }else{
                queue3.insert("Client"+i);
            }
        }

        Thread.sleep(5000);

        queueOne.interrupt();
        queueTwo.interrupt();
        queueThree.interrupt();

        queueOne.join();
        queueTwo.join();
        queueThree.join();

    }
}