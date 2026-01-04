# browser-history-simulation

Browser History simulation using `Stack` in Java.

## Build

```bash
javac -d . BrowserHistory.java 
javac Main.java
```

## Run

```bash
java Main
```

## Usage

- On start, enter the homepage when prompted.
- Commands:
	- `visit <url>` — visit a new URL
	- `back <steps>` — go back up to `<steps>` pages
	- `forward <steps>` — go forward up to `<steps>` pages
	- `show` — display back/forward stacks
	- `help` — show available commands
	- `exit` — quit the program