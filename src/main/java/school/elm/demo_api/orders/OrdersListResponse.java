package school.elm.demo_api.orders;

public class OrdersListResponse {
    private String message;
    private Iterable<Orders> orders;

    public OrdersListResponse(String message, Iterable<Orders> orders) {
        this.message = message;
        this.orders = orders;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Iterable<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Iterable<Orders> orders) {
		this.orders = orders;
	}

    // Add getters and setters for message and orders
}
