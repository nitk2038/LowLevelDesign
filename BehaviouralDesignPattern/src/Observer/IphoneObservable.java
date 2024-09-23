package Observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StocksObservable {
    public List<NotificationAlertObserver>observersList;
    public int stockCount;

    public IphoneObservable() {
        this.observersList = new ArrayList<>();
        this.stockCount = 0;
    }

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        observersList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        observersList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer: observersList) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        //we are getting newStocks , when we were currently out of stock
        if(stockCount == 0) {
            notifySubscribers();
        }
        this.stockCount+=newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
