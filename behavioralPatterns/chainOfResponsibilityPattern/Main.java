package chainOfResponsibilityPattern;

interface Handler {
	void setNextHandler(Handler handler);

	void handleRequest(Request request);
}

class ConcreteHandlerA implements Handler {
	private Handler nextHandler;

	@Override
	public void setNextHandler(Handler handler) {
		this.nextHandler = handler;
	}

	@Override
	public void handleRequest(Request request) {
		if (request.getType().equals(RequestType.TYPE_A)) {
			System.out.println("Handling request of Type A by ConcreteHandlerA");
			// Process the request here
		} else if (nextHandler != null) {
			nextHandler.handleRequest(request);
		}
	}
}

class ConcreteHandlerB implements Handler {
	private Handler nextHandler;

	@Override
	public void setNextHandler(Handler handler) {
		this.nextHandler = handler;
	}

	@Override
	public void handleRequest(Request request) {
		if (request.getType().equals(RequestType.TYPE_B)) {
			System.out.println("Handling request of Type B by ConcreteHandlerB");
			// Process the request here
		} else if (nextHandler != null) {
			nextHandler.handleRequest(request);
		}
	}
}

class Request {
	private final RequestType type;

	public Request(RequestType type) {
		this.type = type;
	}

	public RequestType getType() {
		return type;
	}
}

enum RequestType {
	TYPE_A, TYPE_B
}

public class Main {
	public static void main(String[] args) {
		// Create the chain of handlers
		Handler handlerA = new ConcreteHandlerA();
		Handler handlerB = new ConcreteHandlerB();

		// Set the next handler in the chain
		handlerA.setNextHandler(handlerB);

		// Create some requests
		Request request1 = new Request(RequestType.TYPE_A);
		Request request2 = new Request(RequestType.TYPE_B);
		Request request3 = new Request(RequestType.TYPE_A);

		// Process the requests
		handlerA.handleRequest(request1);
		handlerA.handleRequest(request2);
		handlerA.handleRequest(request3);
	}
}