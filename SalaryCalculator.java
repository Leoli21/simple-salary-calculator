import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/***
 * 
 * @author Leo Li
 * Salary Calculator Project
 *
 */
public class SalaryCalculator
{

	public static void main(String[] args) 
	{	
		JFrame calcFrame = new JFrame("Salary Calculator");
		calcFrame.setBounds(50,100,500,250);
		calcFrame.setLayout(null);
		
		
		JLabel hrRate = new JLabel("Hourly Rate: ");
		hrRate.setBounds(50,25,100,30);
		calcFrame.add(hrRate);
		
		JTextField inputHrRate = new JTextField("");
		inputHrRate.setBounds(150,25,200,30);
		calcFrame.add(inputHrRate);
		
		JLabel time = new JLabel("Hours/Week: ");
		time.setBounds(50,55,100,30);
		calcFrame.add(time);
		
		JTextField timeWorked = new JTextField("");
		timeWorked.setBounds(150,55,200,30);
		calcFrame.add(timeWorked);
		
		JLabel annualSalary = new JLabel("Annual Salary: $");
		annualSalary.setBounds(250,135,200,30);
		calcFrame.add(annualSalary);
		
		JCheckBox fullTimeCheckBox = new JCheckBox("Full Time");
		fullTimeCheckBox.setBounds(55,85,100,50);
		calcFrame.add(fullTimeCheckBox);
		
		fullTimeCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(fullTimeCheckBox.isSelected())
				{
					timeWorked.setText("");
					timeWorked.setEnabled(false);					
				}	
				else
				{
					timeWorked.setEnabled(true);
				}
			}
			
		});
		
		JButton calcBtn = new JButton("Calculate");
		calcBtn.setBounds(52,135,175,30);
		calcFrame.add(calcBtn);
		
		calcBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				double hourlyRate = 0.0;
				double salaryTotal;
				double totalHoursPerWeek = 0.0;
				try {
					hourlyRate = Double.parseDouble(inputHrRate.getText());
					totalHoursPerWeek = Double.parseDouble(timeWorked.getText());
				}
				catch(Exception ex)
				{
					System.out.println("You did not input a numeric value.");
				}
				if(fullTimeCheckBox.isSelected())
				{
					//hourlyRate = Double.parseDouble(inputHrRate.getText());
					salaryTotal = hourlyRate * 40 * 52;
				}
				else 
				{
					//hourlyRate = Double.parseDouble(inputHrRate.getText());
					//totalHoursPerWeek = Double.parseDouble(timeWorked.getText());
					salaryTotal = hourlyRate * totalHoursPerWeek * 52;
				}
				annualSalary.setText("Annual Salary: $" + salaryTotal);
				
			}						
		});
		
		calcFrame.setVisible(true);
		calcFrame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
	}

}
