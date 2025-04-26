package anonymoudinnerclass;

public class AnonymousNotificationSystem {

	public static void main(String[] args) {
		Notification notification = new Notification() {

			@Override
			public void notifyUser() {
				System.out.println("Sending SMS Notification 📱");
			}
		};
		notification.notifyUser();
	}

}
