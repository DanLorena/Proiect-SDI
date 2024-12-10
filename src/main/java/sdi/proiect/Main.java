package sdi.proiect;


import sdi.proiect.model.News;
import sdi.proiect.model.User;
import sdi.proiect.service.ChannelService;
import sdi.proiect.service.NotificationService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChannelService channelService = new ChannelService();
        NotificationService notificationService = new NotificationService();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Channel");
            System.out.println("2. Add News to Channel");
            System.out.println("3. Subscribe User to Channel");
            System.out.println("4. View Notifications");
            System.out.println("5. List News from Channel");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter channel name: ");
                    String channelName = scanner.nextLine();
                    channelService.createChannel(channelName);
                    break;
                case 2:
                    System.out.print("Enter channel name: ");
                    String targetChannel = scanner.nextLine();
                    System.out.print("Enter news title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter news content: ");
                    String content = scanner.nextLine();
                    News news = new News(title, content);
                    channelService.addNewsToChannel(targetChannel, news);
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter channel name: ");
                    String subChannel = scanner.nextLine();
                    User user = new User(userName);
                    channelService.subscribeUserToChannel(subChannel, user);
                    break;
                case 4:
                    System.out.print("Enter user name: ");
                    String notifyUser = scanner.nextLine();
                    System.out.println("Feature not yet implemented to retrieve specific user's notifications.");
                    break;
                case 5:
                    System.out.print("Enter channel name: ");
                    String listChannel = scanner.nextLine();
                    channelService.listNewsFromChannel(listChannel);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
