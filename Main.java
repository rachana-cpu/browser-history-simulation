import java.util.Scanner;
import BrowserHistory.BrowserHistory;

public class Main {
    private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter homepage: ");
		String homepage = sc.nextLine().trim();
		BrowserHistory bh = new BrowserHistory(homepage);
        showHelp();

		while (true) {
			System.out.print("> ");
			String line = sc.nextLine().trim();
			if (line.isEmpty()) continue;
			String[] parts = line.split("\\s+", 2);
			String cmd = parts[0].toLowerCase();
			try {
				switch (cmd) {
					case "visit":
						doVisit(bh, parts);
						break;
					case "back":
						goBack(bh);
						break;
					case "forward":
						goForward(bh);
						break;
                    case "current":
                        System.out.println("Current page: " + bh.getCurrentPage());
                        break;
					case "show":
						bh.printStacks();
						break;
					case "help":
						showHelp();
						break;
					case "exit":
						doExit();
						return;
					default:
						System.out.println("Unknown command. Type 'help'.");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Steps must be an integer.");
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

    private static void showHelp() {
        System.out.println("Commands: visit <url>, back, forward, current, show, help, exit");
    }

    private static void doExit() {
        System.out.println("Exiting browser history simulation.");
        sc.close();
    }

    private static void doVisit(BrowserHistory bh, String[] parts) {
        if (parts.length < 2) {
            System.out.println("Usage: visit <url>");
            return;
        }
        bh.visit(parts[1]);
        System.out.println("Visited: " + parts[1]);
    }

    private static void goBack(BrowserHistory bh) {
        System.out.println("Current page: " + bh.back(1));
    }

    private static void goForward(BrowserHistory bh) {
        System.out.println("Current page: " + bh.forward(1));
    }
}
