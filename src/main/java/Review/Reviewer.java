package Review;

import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



//import javax.ws.rs;
import Classes.Cliente;

public class Reviewer implements ActionListener, Runnable{

	private JFrame frame;
	private JButton buttonEnd;
	private JButton buttonReview;
	private JTextField donation;
	private JTextField total;
	private JLabel message;

	//private Cliente client;
	private Client client;
	//private WebTarget webTarget;

	private Thread thread;
	private final AtomicBoolean running = new AtomicBoolean(false);
	
	public Reviewer(String hostname, String port) {
		
		client = ClientBuilder.newClient();
		//webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));
		
		this.buttonReview = new JButton("Send review");
		this.buttonReview.addActionListener(this);
		this.buttonEnd = new JButton("End Process");
		this.buttonEnd.addActionListener(this);
		this.donation = new JTextField(10);
		this.total = new JTextField(10);
		this.total.setEnabled(false);
		this.message = new JLabel("Welcome to the REST Reviewer Client");
		this.message.setOpaque(true);
		this.message.setForeground(Color.yellow);
		this.message.setBackground(Color.gray);
		
		JPanel panelReviews = new JPanel();
		panelReviews.add(new JLabel("Review: "));
		panelReviews.add(this.donation);
		panelReviews.add(new JLabel("Other reviews: "));
		panelReviews.add(this.total);

		JPanel panelBotones = new JPanel();
		panelBotones.add(this.buttonReview);
		panelBotones.add(this.buttonEnd);

		this.frame = new JFrame("Review: REST Client");
		this.frame.setSize(400, 125);
		this.frame.setResizable(false);		
		this.frame.getContentPane().add(panelReviews, "North");
		this.frame.getContentPane().add(panelBotones);
		this.frame.getContentPane().add(this.message, "South");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WindowManager.middleLeft(this.frame);
		this.frame.setVisible(true);
		

		thread = new Thread(this);
		thread.start();
		
	}
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		if (target == this.buttonEnd) {
			this.stop();
			System.exit(0);
		}

		if (target == this.buttonReview) {
			try {
				int donation = Integer.parseInt(this.donation.getText());
				String review = this.
				this.message.setText("Sending donation ...");
				this.sendDonation(donation);
				this.message.setText("Donation of " + donation + " already sent...");
			} catch (NumberFormatException exc) {
				this.message.setText(" # Error sending donation. Donation must be an integer.");
			} catch (DonationException exc) {
				this.message.setText(" # Error sending donation. ");
			}
		}
	}
	
	public void sendReview(String mensaje) throws DonationException {
		WebTarget donationsWebTarget = webTarget.path("collector/donations");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		
		Review review = new Review(mensaje);
		Response response = invocationBuilder.post(Entity.entity(donation, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new DonationException("" + response.getStatus());
		}
	}

	public DonationInfo getDonationInfo() throws DonationException {
		WebTarget donationsWebTarget = webTarget.path("collector/donations");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == Status.OK.getStatusCode()) {
			DonationInfo donationInfo = response.readEntity(DonationInfo.class);
			return donationInfo;
		} else {
			throw new DonationException("" + response.getStatus());
		}
	}
	
	
	public void run() {
		running.set(true);
		while(running.get()) {
			try { 
				Thread.sleep(2000);
				System.out.println("Obtaining data from server...");
				try {
					DonationInfo donationInfo = getDonationInfo();
					this.total.setText(Integer.toString(donationInfo.getTotal()));
				} catch (DonationException e) {
					System.out.println(e.getMessage());
				}
            } catch (InterruptedException e){ 
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted, Failed to complete operation");
            }
		}
	}


	public void stop() {
		this.running.set(false);
	}

	
	
	
}
