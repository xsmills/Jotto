package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import model.JottoModel;

/**
 * // TODO Write specifications for your JottoGUI class.
 */
public class JottoGUI extends JFrame {

	private JButton newPuzzleButton;
	private JTextField newPuzzleNumber;
	private JLabel puzzleNumber;
	private JTextField guess;
	private JLabel makeGuess;
	private JTable guessTable;
	private JottoModel jottoModel;

	private JottoGUI jottoGUI;
	private int puzzleNum;
	private int currentRow = 1;
	private int defaultWidth = 1000;

	public JottoGUI() {
		jottoModel = new JottoModel();
		// TODO Problem 3, 4, and 5
		setTitle("Jotto Game");

		// define layout
		final JPanel panel = new JPanel(new BorderLayout());
		Container contentPane = getContentPane();
		GroupLayout layout = new GroupLayout(contentPane);
		contentPane.setLayout(layout);
		setPreferredSize(new Dimension(400, 400));

		// get some margins around components by default
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);

		Random r = new Random();
		puzzleNum = r.nextInt(10000);

		newPuzzleButton = new JButton("New Puzzle");
		newPuzzleButton.setName("newPuzzleButton");

		// int puzzleNum = jottoModel.getPuzzleNum();
		puzzleNumber = new JLabel();
		puzzleNumber.setText("puzzle #" + puzzleNum);
		puzzleNumber.setName("puzzleNumber");

		newPuzzleNumber = new JTextField();
		newPuzzleNumber.setName("newPuzzleNumber");
		newPuzzleNumber.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				if (event.getKeyCode() == KeyEvent.VK_ENTER) {
					int puzzleNum = Integer.parseInt(newPuzzleNumber.getText());
					puzzleNumber.setText("puzzle #" + puzzleNum);
				}
			}
		});

		guess = new JTextField();
		guess.setName("guess");
		guess.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				if (event.getKeyCode() == KeyEvent.VK_ENTER) {
					// String guessString = guess.getText();
					
					Thread t = new Thread(new Runnable() {
						public void run() {

							try {
								
								String guessString = guess.getText();
								guess.setText("");
								
								// String output = jottoModel.makeGuess(puzzleNum,
								// guessString);
								
								Vector<String> rowDataVector = new Vector<String>();
								((DefaultTableModel) guessTable.getModel()).addRow(rowDataVector);
								int currentRow = guessTable.getModel().getRowCount()-1;
								((DefaultTableModel) guessTable.getModel())
								.setValueAt(guessString, currentRow, 0);
								
								String output = jottoModel.makeGuess(puzzleNum,
										guessString);
								System.out.println(output);
								String[] columns = output.split(" ");
							
								//rowDataVector.add(guessString);
								if (columns[0].equals("error")) {
									((DefaultTableModel) guessTable.getModel())
									.setValueAt("Invalid input", currentRow, 1);
									//rowDataVector.add("Invalid input");
									//rowDataVector.add("");
								} else if (columns[1].equals("5") && columns[2].equals("5")) {
									//System.out.println("Printing real input");
									((DefaultTableModel) guessTable.getModel())
									.setValueAt("You win!", currentRow, 1);
									
									//rowDataVector.add("You win!");
									//rowDataVector.add("");
								} else {
									//System.out.println("Printing real input");
									((DefaultTableModel) guessTable.getModel())
									.setValueAt(columns[1], currentRow, 1);
									((DefaultTableModel) guessTable.getModel())
									.setValueAt(columns[2], currentRow, 2);
									//rowDataVector.add(columns[1]);
									//rowDataVector.add(columns[2]);
								}
								//((DefaultTableModel) guessTable.getModel())
										//.setValueAt(content, currentRow, colNum);

								

								if (output.equals("guess 5 5")) {
									System.out
											.println("You guessed the secret word! You win!");
								}
								
								
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});

					t.start();
					

				
				}

			}

		});

		makeGuess = new JLabel("Type a guess here: ");

		guessTable = new JTable(1, 3);
		Vector<String> rowDataVector = new Vector<String>();
		rowDataVector.add("Guess");
		rowDataVector.add("Common Letters");
		rowDataVector.add("Correct Positions");

		((DefaultTableModel) guessTable.getModel()).addRow(rowDataVector);
		guessTable.setName("guessTable");

		// place the components in the layout (which also adds them
		// as children of this view)
		layout.setHorizontalGroup(layout
				.createParallelGroup()
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(puzzleNumber)
								.addComponent(newPuzzleButton)
								.addComponent(newPuzzleNumber))
				.addGroup(
						layout.createSequentialGroup().addComponent(makeGuess)
								.addComponent(guess))
				.addGroup(
						layout.createSequentialGroup().addComponent(guessTable)));

		layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup().addComponent(puzzleNumber)
								.addComponent(newPuzzleButton)
								.addComponent(newPuzzleNumber))
				.addGroup(
						layout.createParallelGroup().addComponent(makeGuess)
								.addComponent(guess))
				.addGroup(layout.createParallelGroup().addComponent(guessTable))

		);
		
		this.pack();
		this.setSize(defaultWidth, getHeight());

	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JottoGUI main = new JottoGUI();

				main.setVisible(true);
			}
		});
	}
}
