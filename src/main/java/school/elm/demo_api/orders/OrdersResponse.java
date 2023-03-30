package school.elm.demo_api.orders;

public class OrdersResponse {
    private String message;
    private Orders order;

    public OrdersResponse(String message, Orders order) {
        this.message = message;
        this.order = order;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

    // Add getters and setters for message and order
}
