import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 2_000, "KVK", "ARH", 120);
    Ticket ticket2 = new Ticket(22, 10_000, "LED", "AER", 150);
    Ticket ticket3 = new Ticket(333, 2_800, "SVO", "KZN", 95);
    Ticket ticket4 = new Ticket(4444, 3_000, "SVO", "KZN", 95);
    Ticket ticket5 = new Ticket(55, 1_299, "SVO", "KZN", 95);
    Ticket ticket6 = new Ticket(6, 2_199, "SVO", "KZN", 95);
    Ticket ticket7 = new Ticket(777, 2_300, "SVO", "KZN", 95);
    Ticket ticket8 = new Ticket(55555, 3_200, "VKO", "KZN", 95);


    @Test
    public void shouldSearchAndSortTicketsFromSVOToKZN() {
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket5, ticket6, ticket7, ticket3, ticket4};
        Ticket[] actual = manager.searchBy("SVO", "KZN");
    }

    @Test
    public void shouldNotSearchAndSortTicketsIfNoTicketsAdded() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("SVO", "KZN");
    }

    @Test
    public void shouldNotSearchTicketsFromSVOToKZNIfTheyDoNotAdded() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("SVO", "KZN");
    }

    @Test
    public void shouldSearchTicketIfOneTicketAdded() {
        manager.add(ticket4);

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.searchBy("SVO", "KZN");
    }
}