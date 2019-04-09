package actions;

import java.io.IOException;

public class SortByPrice {
    CompleteTask completeTask = new CompleteTask();

    public void sortProductsByPrice() throws IOException, InterruptedException {
        completeTask.goToNikeStoreAndCompleteTask("nike.com");
    }

}
