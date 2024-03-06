package de.viperpit.browser;

import static org.eclipse.swt.SWT.EDGE;
import static org.eclipse.swt.SWT.MenuDetect;
import static org.eclipse.swt.SWT.NONE;
import static org.eclipse.swt.SWT.NO_SCROLL;
import static org.eclipse.swt.SWT.NO_TRIM;
import static org.eclipse.swt.SWT.POP_UP;
import static org.eclipse.swt.SWT.PUSH;
import static org.eclipse.swt.SWT.Selection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.TitleEvent;
import org.eclipse.swt.browser.TitleListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;

public class BrowserApplication {

	public static void main(String[] args) {
		new BrowserApplication().run();
	}

	private Browser browser;

	private Shell shell;

	private void exit() {
		browser.dispose();
		System.exit(0);
	}

	private void installTrayMenu(Shell shell) {
		Display display = shell.getDisplay();

		Tray tray = display.getSystemTray();
		if (tray == null) {
			return;
		}

		Image image = new Image(display, BrowserApplication.class.getResourceAsStream("/icon.ico"));
		TrayItem item = new TrayItem(tray, NONE);
		item.setToolTipText("Viperpit Browser");

		Menu menu = new Menu(shell, POP_UP);

		MenuItem refreshMenuItem = new MenuItem(menu, PUSH);
		refreshMenuItem.setText("Refresh");
		refreshMenuItem.addListener(Selection, new Listener() {
			public void handleEvent(Event event) {
				refresh();
			}
		});

		MenuItem exitMenuItem = new MenuItem(menu, PUSH);
		exitMenuItem.setText("Exit");
		exitMenuItem.addListener(Selection, new Listener() {
			public void handleEvent(Event event) {
				image.dispose();
				exit();
			}
		});
		menu.setDefaultItem(exitMenuItem);

		item.addListener(MenuDetect, new Listener() {
			public void handleEvent(Event event) {
				menu.setVisible(true);

			}
		});
		item.setImage(image);
	}

	private void openBrowserWindow(Shell shell, BrowserApplicationSettings settings) {
		shell.setLayout(new FillLayout());
		shell.setBounds(settings.x(), settings.y(), settings.width(), settings.height());
		browser = new Browser(shell, EDGE | NO_SCROLL);
		browser.addTitleListener(new TitleListener() {
			public void changed(TitleEvent event) {
				shell.setText(event.title);
			}
		});
		shell.open();
		browser.setUrl(settings.url());
	}

	private void refresh() {
		browser.refresh();
	}

	private void run() {
		BrowserApplicationSettings settings = loadSettings();
		
		boolean isUrlReachable = false;
		String url = settings.url();
		
		while(!isUrlReachable) {
			try {
				Thread.sleep(1000);
				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
				connection.setRequestMethod("GET");
				isUrlReachable = connection.getResponseCode() == 200;
			} catch (InterruptedException exception) {
				throw new RuntimeException(exception);
			} catch (IOException exception) {
				// This is expected...
			}
		}

		Display display = new Display();
		shell = new Shell(display, NO_TRIM | NO_SCROLL);
		installTrayMenu(shell);
		openBrowserWindow(shell, settings);

		while (!shell.isDisposed()) {
			if (display.readAndDispatch()) {
				continue;
			}
			display.sleep();
		}
	}

	private BrowserApplicationSettings loadSettings() {
		Properties properties = new Properties();
		try {
			File parentFile = new File(".");
			String parentPath = parentFile.getCanonicalPath();

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(parentPath);
			stringBuilder.append(File.separator);
			stringBuilder.append("browser.properties");

			File propertiesFile = new File(stringBuilder.toString());

			properties.load(new FileInputStream(propertiesFile));

		} catch (IOException exception) {
			exception.printStackTrace();
		}

		return new BrowserApplicationSettings(properties);
	}

}