package lambdaExpression;

//LambdaNotificationSystem.java
/**
 * Demonstrates Notification sending using Lambda Expression.
 */
public class LambdaNotificationSystem {

	public static void main(String[] args) {
		// Lambda expression implementation of Notification interface
		Notification notification = () -> System.out.println("Sending Push Notification 🔔");
		// Sending notification
		notification.notifyUser();
	}

}
