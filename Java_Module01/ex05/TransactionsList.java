import java.util.UUID;

public interface TransactionsList {

    public void add(Transaction transaction);

    public Transaction removeById(UUID id);

    public Transaction[] toArray();

}