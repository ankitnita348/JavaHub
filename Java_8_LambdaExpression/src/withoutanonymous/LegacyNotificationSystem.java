package withoutanonymous;

public class LegacyNotificationSystem {

	public static void main(String[] args) {
		EmailNotification notification = new EmailNotification();
		notification.notifyUser();
	}

}
